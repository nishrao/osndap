package io.osndap.tftp.protocol.packet;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

@Getter @Setter
public abstract class TftpPacket {
    public static final Charset CHARSET = StandardCharsets.ISO_8859_1;

    @NonNull
    private SocketAddress remoteAddress;

    public abstract TftpOpCode getOpCode();
    /** Opcode is read already */
    public abstract void decode(@NonNull ByteBuffer buffer);

    protected static String decodeString(@NonNull ByteBuffer buffer) {
        int start = buffer.position();
        int finish;
        int end=-1;
        for(finish=start; finish < buffer.limit(); finish++) {
            if(buffer.get(finish) == 0) {
                end = finish;
                finish++; // Move the pointer to net block
                break; // We have found the NULL Terminator or zero byte
            }
        }
        //we have not found the zero byte or null terminator
        if(end==-1)
            end = buffer.limit();
        byte[] bytes = new byte[end - start];
        buffer.get(bytes);
        buffer.position(finish); //Move the pointer to next block
        return new String(bytes, CHARSET);
    }

}
