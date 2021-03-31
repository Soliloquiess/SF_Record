package csv;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ReadCSVTest {
	private static ReadCSVTest readCSVTest = new ReadCSVTest();
	private static List<Maintenance> envAreaList = new ArrayList<>();

    // private static String csvFileName = "c:/ssafy/서울시 종로구 환경 지도점검 내역 현황.csv";
    // private static String csvFileName = "/src/csv/서울시 종로구 환경 지도점검 내역 현황.csv";
    private static String csvFileName = "./src/csv/서울시 종로구 환경 지도점검 내역 현황.csv";

    static {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(csvFileName)))) {
            String line;

            br.readLine();
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                String name = values[0];
                String licenseNum = values[1];
                int code = Integer.parseInt(values[2]);
                String type = values[3];
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
                LocalDate date = LocalDate.parse(values[4], formatter);
                String maintainer = values[5];
                String maintainerName = values[6];
                String maintainedTime = values[7];
                boolean isTrash = "Y".equals(values[8]);
                String content = values[9];
                String roadAddress = values[11];
                String homeAddress = values[12];

                Maintenance maintenance = new Maintenance(name, licenseNum, code, type, date, maintainer, maintainerName, maintainedTime, isTrash, content, roadAddress, homeAddress);

                envAreaList.add(maintenance);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static ReadCSVTest getInstance() {
        return readCSVTest;
    }

    private ReadCSVTest() {

    }

    public void search(String dong) {
        List<Maintenance> collect  = new ArrayList<>();
    	 
        for(Maintenance m : envAreaList) {
            if(m.containsAddress(dong)) {
                collect.add(m);
            }
        }
         if(collect.isEmpty()) {
             System.out.println(dong + "에 해당하는 환경지도내역이 없습니다.");
             return;
        }
 
        for(Maintenance m : collect) {
            System.out.println(m);
        }
    }

    public static void main(String[] args) throws Exception {
        {


//			// 상권 정보
//			List<List<String>> bizAreaList = new ArrayList<>();
//
//			String csvFileName = "c:" + File.separator + "SSAFY" + File.separator + "상가정보_샘플.csv";
//			try (BufferedReader br = new BufferedReader(new FileReader(csvFileName))) {
//			    String line;
//
//			    while ((line = br.readLine()) != null) {
//			    	String[] values = line.split("\\|");
//
//			        System.out.println(Arrays.toString(values));
//			        bizAreaList.add(Arrays.asList(values));
//			    }
//			}
        }
        // {
        //     // 환경 정보
        //     // euc-kr
        //     List<Maintenance> envAreaList = new ArrayList<>();

		// 	String csvFileName = "c:/ssafy/서울시 성북구 환경 지도점검 내역 현황.csv";
        //     try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(csvFileName), "euc-kr"))) {
        //         String line;

        //         br.readLine();
        //         while ((line = br.readLine()) != null) {
        //             String[] values = line.split(",");

        //             for (int i = 0; i < values.length; i++){
        //                 if(values[i].isEmpty()) continue;  
		// 				values[i] = values[i].substring(1, values[i].length() - 1);
        //             }

        //             String name = values[0];
        //             String licenseNum = values[1];
        //             int code = Integer.parseInt(values[2]);
        //             String type = values[3];
        //             DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        //             LocalDate date = LocalDate.parse(values[4], formatter);
        //             String maintainer = values[5];
        //             String maintainerName = values[6];
        //             String maintainedTime = values[7];
        //             boolean isTrash = "Y".equals(values[8]);
        //             String content = values[9];
        //             String roadAddress = values[11];
        //             String homeAddress = values[12];

        //             Maintenance maintenance = new Maintenance(name, licenseNum, code, type, date, maintainer, maintainerName, maintainedTime, isTrash, content, roadAddress, homeAddress);

        //             envAreaList.add(maintenance);
        //             System.out.println(maintenance);
        //             System.out.println();
        //         }
        //     }
        // }
    }
}

