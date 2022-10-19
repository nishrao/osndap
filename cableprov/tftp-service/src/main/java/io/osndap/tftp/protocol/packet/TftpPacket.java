package io.osndap.tftp.protocol.packet;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.net.SocketAddress;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

@Getter @Setter
public abstract class TftpPacket {
    public static final Charset CHARSET = StandardCharsets.UTF_8;

    @NonNull
    private SocketAddress remoteAddress;

    public abstract TftpOpCode getOpCode();
}
