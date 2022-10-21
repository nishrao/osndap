package io.osndap.tftp.protocol.packet;

public class TftpWRQPacket extends TftpRequestPacket {
    @Override
    public TftpOpCode getOpCode() {
        return TftpOpCode.WRQ;
    }
}
