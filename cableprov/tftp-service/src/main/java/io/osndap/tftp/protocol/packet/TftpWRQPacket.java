package io.osndap.tftp.protocol.packet;

public class TftpWRQPacket extends TftpRequest{
    @Override
    public TftpOpCode getOpCode() {
        return TftpOpCode.WRQ;
    }
}
