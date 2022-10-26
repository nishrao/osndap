package io.osndap.tftp.codec;

import io.osndap.tftp.protocol.packet.TftpOpCode;
import io.osndap.tftp.protocol.packet.TftpPacket;
import io.osndap.tftp.protocol.packet.TftpRRQPacket;
import io.osndap.tftp.protocol.packet.TftpWRQPacket;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.net.SocketAddress;
import java.nio.ByteBuffer;

@Slf4j
@Component
public class TftpCodec {

    @NonNull
    public TftpPacket decode(@NonNull SocketAddress remoteAddress, @NonNull ByteBuffer buf) {
        TftpOpCode opcode = TftpOpCode.forCode(buf.getShort());
        TftpPacket packet;
        switch(opcode) {
            case RRQ:
                packet = new TftpRRQPacket();
                break;
            case WRQ:
                packet = new TftpWRQPacket();
                break;
            default:
                throw new IllegalStateException("Unknown Opcode in the request : " + opcode);
        }
        packet.setRemoteAddress(remoteAddress);
        packet.decode(buf);
        if(buf.position() < buf.limit()) {
            log.warn("Discarded " + (buf.limit() - buf.position()) + " trailing bytes in TFTP packet");
        }
        return packet;
    }
}
