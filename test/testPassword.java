package test;

import src.utils.Password;

public class testPassword {

    private static Password p1 = new Password();

    private final static String[][] getPasswords(boolean bool) {
        String reallyCrap1[] = { "aaaa", "AAAA", "1234", "d", "s", "#@!" };
        String crap1[] = { "aaaaa", "AAAAA", "12345", "@#$!@", "asasw" };
        String weak1[] = { "asdS2A", "SD7sda", "213aSd", "dSa321", "#@!Aad" };
        String good1[] = { "Sd@!2", "d2$S", "aCd2#!#", "Lu@#!2" };
        String veryGood1[] = { "uQuad@r23", "rSvad#r23", ".|_-Z#r23" }; // 8>
        String noClassified1[] = { "Quad@r23", "DSASDSA", "asdSXDAS", "232ss@#@" };

        String reallyCrap2[] = { "AAaa", "AA@#", "SD21", "DASdasds", "#!@#@", "#DASDA@!", "" };
        String crap2[] = { "AAaad", "dAA@#", "SdD21", "s", "DdASdasds", "#!@@#@", "#DXASDA@!", "" };
        String weak2[] = { "assdSDA", "SDSssa", "2123aSd", "212@sd", "dDa@21", "#@s!sad" };
        String good2[] = { "Sd@!s", "d2ssDS", "asd#!#", "Lu@#!" };
        String veryGood2[] = { "", "uQuad@r2", "rSvad#r3", ".|_-Z#r3" }; // 8>
        String noClassified2[] = { "aaaaa", "AAAAA", "12345", "D", "S", "aaaa", "AAAA", "1345" };

        final String goodPasswords[][] = { reallyCrap1, crap1, weak1, good1, veryGood1,
                noClassified1 };

        final String badPasswords[][] = { reallyCrap2, crap2, weak2, good2, veryGood2,
                noClassified2 };

        return bool ? goodPasswords : badPasswords;
    }

    public static void main(String[] args) {
        String[] classification  = { "Muito Ruim", "Ruim", "Fraca", "Boa", "Muito Boa", "N/A"};

        String[][] goods = getPasswords(true);
        String[][] bads = getPasswords(false);
        for (int i = 0; i < goods.length; i++) {
            for (int j = 0; j < goods[i].length; j++){
                if(!compare(goods[i][j], i)){
                    System.out.printf("%s is not %s - ", goods[i][j], classification[i]);
                    System.out.printf("%s is %s\n\n", goods[i][j], classification[p1.classifyPassword(goods[i][j])]);
                }
                   
            }
        }
        for (int i = 0; i < bads.length; i++) {
            for (int j = 0; j < bads[i].length; j++){
                if(compare(bads[i][j], i)) 
                    System.out.printf("%s is %s - ", bads[i][j], classification[i]);              
                
            }
        }
    }

    private static boolean compare(String pass, int quality) {
        return quality == p1.classifyPassword(pass);
    }
}