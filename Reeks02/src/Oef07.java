public class Oef07 {
    public static void main(String[] args) {
        String rommeltje = "V@;schAi}N$ldp@_@EEN_?{aGdOden !E}:kuD_nnCOMen)%PLI@MEN:T _mKAN_IK_T/W§.:e(.EeEr,"
                + "_ o§;v(erMA§A :*d!e §NDEwN/e,%g _LverEtV,;Ee.N_l/__;l)e_n _£da__@n _,M)haA}Rz}en £,K_ TWA"
                + "%  .?I,N  /,,;   % )  @ § @  ) :          k,.a)}hlil g;i§b;(r/an";
        /*
        String rommeltje = "}Vd§ReO £E§eGEen;*!Rza_a(.mA)L%/S(h_e)iEdR_VIS;}%sI isT E{_KWA%/een, stil£.@lM?e s_Gt"
                   +"£*%/AVEo!;rN$m: _§WE_diK}(e£ ).!O$al//F oF.I}En(z_e:_ _d;o__de_ t/_a_kkN:eUn/_G )EaV:E}$N,f_WEb"
                   + "_,O/r%eN£Z*Ee{k_tW@)!!? IF;I, *_{CO D{E    *!    !.;{;}ka)h£li)?l%! gi(br!§§}.a?n";
        */

        StringBuilder zin1 = new StringBuilder();
        StringBuilder zin2 = new StringBuilder();
        for (int i = 0; i < rommeltje.length(); i++) {
            if (rommeltje.charAt(i) == ' ' || Character.isLetter(rommeltje.charAt(i)) && Character.isLowerCase(rommeltje.charAt(i))) {

                zin1.append(rommeltje.charAt(i));

            } else if (rommeltje.charAt(i) == '_' || Character.isLetter(rommeltje.charAt(i)) && Character.isUpperCase(rommeltje.charAt(i))) {

                zin2.append(rommeltje.charAt(i));
            }

        }
        System.out.println(zin1);
        System.out.println(zin2);
    }
}
