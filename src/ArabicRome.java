public class ArabicRome {
    String[] arab = {"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20"};
    String[] rome = {"I","II","III","IV","V","VI","VII","VIII","IX","X","XI","XII","XIII","XIV","XV","XVI","XVII","XVIII","XIX","XX"};
    public boolean isArabic(String number){
        for (String string: rome){
            if (number.equals(string)){
                return true;
            }
        }
        return false;
    }

    public String RomanianToArabic(String romanian){
        int i = 0;
        for (String string: rome){
            if (romanian.equals(string)){
                return arab[i];
            }
            i++;
        }
        return romanian;
    }

    public String ArabicToRomanian(int arabic){
        int i = 0;
        String arabic_string = Integer.toString(arabic);
        for (String string: arab){
            if (arabic_string.equals(string)){
                return rome[i];
            }
            i++;
        }
        return arabic_string;
    }
}
