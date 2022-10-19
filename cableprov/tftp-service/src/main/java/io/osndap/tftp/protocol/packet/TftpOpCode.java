package io.osndap.tftp.protocol.packet;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public enum TftpOpCode {
    RRQ(1 , "Read Request"),
    WRQ(2, "Write Request"),
    DATA(3, "Data Packet"),
    ACK(4, "Ack Packet"),
    ERROR(5, "Error Packet"),
    ACK_WITH_OPTIONS(6, "Ack with options");

    private final short code;
    private final String description;

    TftpOpCode(int code, String description) {
        this.code = (short) code;
        this.description = description;
    }

    public static TftpOpCode forCode(short code) {
        for(TftpOpCode opCode : TftpOpCode.values()) {
            if(opCode.getCode() == code) {
                return opCode;
            }
        }
        throw new IllegalArgumentException("No Such TFTP Opcode " + code);
    }
}
