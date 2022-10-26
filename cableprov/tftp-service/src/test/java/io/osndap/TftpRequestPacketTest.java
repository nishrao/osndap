package io.osndap;

import io.osndap.tftp.codec.TftpCodec;
import io.osndap.tftp.protocol.packet.TftpRRQPacket;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TftpRequestPacketTest {

    ByteBuffer buffer;

    @BeforeAll
    public void setup() {
        buffer = ByteBuffer.allocate(512);
        buffer= buffer.putShort((short) 1);
        buffer = buffer.put("file1.txt".getBytes(StandardCharsets.UTF_8));
        buffer = buffer.put((byte)0);
        buffer = buffer.put("octet".getBytes(StandardCharsets.UTF_8));
        buffer = buffer.put((byte)0);
        buffer.limit(buffer.position());
        buffer.rewind();
    }

    @Test
    public void testReadRequest() {
        System.out.println(buffer.limit());
        TftpCodec codec = new TftpCodec();
        TftpRRQPacket packet = (TftpRRQPacket) codec.decode(new InetSocketAddress(1109), buffer);
        Assertions.assertEquals("file1.txt", packet.getFileName());
    }

}
