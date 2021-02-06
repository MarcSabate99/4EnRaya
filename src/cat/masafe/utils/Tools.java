package cat.masafe.utils;

public class Tools {

    public static int getButtonColumn(String userData){
        String[] splitedData = splitButtonUserData(userData);
        return Integer.parseInt(splitedData[0]);
    }

    private static String[] splitButtonUserData(String userData) {
        return userData.split("-");
    }

    public static int getButtonRow(String userData){
        String[] splitedData = splitButtonUserData(userData);
        return Integer.parseInt(splitedData[1]);
    }

}
