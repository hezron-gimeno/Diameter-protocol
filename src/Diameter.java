public class Diameter {
    public static void main(String[] args) {
        byte bytes[] = {
                0x01,0x00,0x00,(byte)0xe8,
                0x00,0x00,0x01,0x01,
                0x00,0x00,0x00,0x00,
                0x00,0x20,0x4a,0x16,
                0x67,0x70,0x00,0x00,
                0x00,0x00,0x01,0x0c,
                0x40,0x00,0x00,0x0c,
                0x00,0x00,0x07,(byte)0xd1,
                0x00,0x00,0x01,0x08,
                0x40,0x00,0x00,0x1a,
                0x67,0x77,0x2e,0x65,
                0x61,0x70,0x2e,0x74,
                0x65,0x73,0x74,0x62,
                0x65,0x64,0x2e,0x61,
                0x61,0x61,0x00,0x00,
                0x00,0x00,0x01,0x28,
                0x40,0x00,0x00,0x17,
                0x65,0x61,0x70,0x2e,
                0x74,0x65,0x73,0x74,
                0x62,0x65,0x64,0x2e,
                0x61,0x61,0x61,0x00,
                0x00,0x00,0x01,0x16,
                0x40,0x00,0x00,0x0c,
                0x4b,(byte)0xed,0x16,0x3e,
                0x00,0x00,0x01,0x01,
                0x40,0x00,0x00,0x0e,
                0x00,0x01,(byte)0xc0,(byte)0xa8,
                0x69,0x1e,0x00,0x00,
                0x00,0x00,0x01,0x01,
                0x40,0x00,0x00,0x1a,
                0x00,0x02,(byte)0xfd,(byte)0xe4,
                0x2c,0x6e,0x55,(byte)0xc4,
                0x01,0x05,0x0a,0x00,
                0x27,(byte)0xff,(byte)0xfe,(byte)0xf0,
                (byte)0xa1,0x70,0x00,0x00,
                0x00,0x00,0x01,0x0a,
                0x40,0x00,0x00,0x0c,
                0x00,0x00,0x00,0x00,
                0x00,0x00,0x01,0x0d,
                0x00,0x00,0x00,0x14,
                0x66,0x72,0x65,0x65,
                0x44,0x69,0x61,0x6d,
                0x65,0x74,0x65,0x72,
                0x00,0x00,0x01,0x0b,
                0x00,0x00,0x00,0x0c,
                0x00,0x00,0x00,0x64,
                0x00,0x00,0x01,0x2b,
                0x40,0x00,0x00,0x0c,
                0x00,0x00,0x00,0x00,
                0x00,0x00,0x01,0x02,
                0x40,0x00,0x00,0x0c,
                0x00,0x00,0x00,0x01,
                0x00,0x00,0x01,0x03,
                0x40,0x00,0x00,0x0c,
                0x00,0x00,0x00,0x03,
                0x00,0x00,0x01,0x02,
                0x40,0x00,0x00,0x0c,
                0x00,0x00,0x00,0x05
        };
//        Version  this is index 1
        int version = 0;
        version |= (bytes[0] &0xff);
        System.out.println("Version -->" + version);

//        Message Length  => index 1,2,3
        int messageLength = 0;
        messageLength |=(bytes[1]&0xff)<<16;
        messageLength |=(bytes[2]&0xff)<<8;
        messageLength |= (bytes[3]&0xff);
        System.out.println("Message Length --> "+ messageLength);

//        Command Flags => index 4
        boolean request = ((bytes[4]&0xff) & 0b10000000) >0;
        System.out.println("Request -->" + request);

        boolean proxible = ((bytes[4]&0xff) &0b01000000) >0;
        System.out.println("Proxible --> "+ proxible);

        boolean error= ((bytes[4] &0xff) &0b00100000) >0;
        System.out.println("Error -->"+error);

        boolean transmitted= ((bytes[4] &0xff) &0b00010000) >0;
        System.out.println("Transmitted -->"+transmitted);

        boolean reserved= ((bytes[4] &0xff) &0b00001111) >0;
        System.out.println("reserved-->"+reserved);

//        Command Codes => indexes 5,6,7
        int commandCode = 0;
        commandCode |= (bytes[5] &0xff)<<16;
        commandCode |= (bytes[6] &0xff)<<8;
        commandCode |= (bytes[7] &0xff);
        System.out.println("Command Code -->" + commandCode);

//        Application Id indexes 8,9,10,11
         int applicationId= 0;
         applicationId |=(bytes[8]&0xff)<<24;
         applicationId |=(bytes[9] &0xff)<<16;
         applicationId |=(bytes[10] &0xff)<<8;
         applicationId |=(bytes[11] &0xff);
        System.out.println("Application Id --> " + applicationId);

//        Hope by hope indentifier
//        indexes 12,13,14,15
        int hopeIdentifier = 0;
        hopeIdentifier |=(bytes[12]&0xff)<<24;
        hopeIdentifier |=(bytes[13] &0xff)<<16;
        hopeIdentifier |= (bytes[14] &0xff)<<8;
        hopeIdentifier |=(bytes[15] &0xff);
        System.out.println("Hope-by-hope identifier --> "+ hopeIdentifier);

//        end to end Indentifier indexes 16,17,18,19
        int endIdentifier = 0;
        endIdentifier |= (bytes[16] &0xff)<<24;
        endIdentifier |= (bytes[17] &0xff)<<16;
        endIdentifier |= (bytes[18] &0xff)<<8;
        endIdentifier |= (bytes[19] &0xff);
        System.out.println("end-to-end identifier -->" + endIdentifier);

//        AVP header indexes 20,21,22,23
        int avpCode = 0;
        avpCode |= (bytes[20] &0xff)<<24;
        avpCode |= (bytes[21] &0xff)<<16;
        avpCode |=(bytes[22] &0xff)<<8;
        avpCode |=(bytes[23] &0xff);
        System.out.println("AVP code --> " + avpCode);

        //flags
        //index 24
        boolean vendor =((bytes[24] &0xff) &0b10000000) >0;
        System.out.println("Vendor-Specific-->"+ vendor);

        boolean mandatory =((bytes[24] &0xff) &0b01000000) >0;
        System.out.println("mandatory-->"+ mandatory);

        boolean p =((bytes[24] &0xff) &0b00100000) >0;
        System.out.println("protected-->"+ p);

        boolean reserve  =((bytes[24] &0xff) &0b00010000) >0;
        System.out.println("Vendor-Specific-->"+ reserve);

        //Avp Length
        //indexes 25,26,27
        int avpLength =0;
        avpLength |= (bytes[25] &0xff)<<16;
        avpLength |= (bytes[26] &0xff)<<8;
        avpLength |= (bytes [27] &0xff);
        System.out.println("AVP-Length -->"+avpLength);

        //vendor ID --indexes 28,29,30,31
        int vendorId =0;
        vendorId |= (bytes[28] &0xff) <<24;
        vendorId |= (bytes[29] &0xff) <<16;
        vendorId |= (bytes[30] &0xff) <<8;
        vendorId |= (bytes[31] &0xff);
        System.out.println("Vendor ID -->" +vendorId);




    }
}
