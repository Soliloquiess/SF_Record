package csv;

import java.time.LocalDate;

public class Maintenance {
    private String name;//업체(시설)명
    private String licenseNum; //인허가번호
    private int code;//업종코드
    private String type;//업종명
    private LocalDate date; //지도점검일
    private String maintainer; //점검기관
    private String maintainerName; // 점검기관명
    private String maintainedTime;//지도점검구분
    private boolean isTrash;//처분대상여부
    private String content;//점검사항
    private String roadAddress;//소재지도로명 주소
    private String homeAddress;

    public Maintenance(String name, String licenseNum, int code, String type, LocalDate date, String maintainer, String maintainerName, String maintainedTime, boolean isTrash, String content, String roadAddress, String homeAddress) {
        this.name = name;
        this.licenseNum = licenseNum;
        this.code = code;
        this.type = type;
        this.date = date;
        this.maintainer = maintainer;
        this.maintainerName = maintainerName;
        this.maintainedTime = maintainedTime;
        this.isTrash = isTrash;
        this.content = content;
        this.roadAddress = roadAddress;
        this.homeAddress = homeAddress;
    }

    public boolean containsAddress(String dong) {
        boolean flag = false;
        if(roadAddress != null && roadAddress.contains(dong)) {
            flag = true;
        }

        if(homeAddress != null && homeAddress.contains(dong)) {
            flag = true;
        }

        return flag;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLicenseNum() {
        return licenseNum;
    }

    public void setLicenseNum(String licenseNum) {
        this.licenseNum = licenseNum;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getMaintainer() {
        return maintainer;
    }

    public void setMaintainer(String maintainer) {
        this.maintainer = maintainer;
    }

    public String getMaintainerName() {
        return maintainerName;
    }

    public void setMaintainerName(String maintainerName) {
        this.maintainerName = maintainerName;
    }

    public String getMaintainedTime() {
        return maintainedTime;
    }

    public void setMaintainedTime(String maintainedTime) {
        this.maintainedTime = maintainedTime;
    }

    public boolean isTrash() {
        return isTrash;
    }

    public void setTrash(boolean trash) {
        isTrash = trash;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getRoadAddress() {
        return roadAddress;
    }

    public void setRoadAddress(String roadAddress) {
        this.roadAddress = roadAddress;
    }

    public String getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(String homeAddress) {
        this.homeAddress = homeAddress;
    }

    @Override
    public String toString() {
        return "Maintenance{" +
                "name='" + name + '\'' +
                ", licenseNum='" + licenseNum + '\'' +
                ", code=" + code +
                ", type='" + type + '\'' +
                ", date=" + date +
                ", maintainer='" + maintainer + '\'' +
                ", maintainerName='" + maintainerName + '\'' +
                ", maintainedTime='" + maintainedTime + '\'' +
                ", isTrash=" + isTrash +
                ", content='" + content + '\'' +
                ", roadAddress='" + roadAddress + '\'' +
                ", homeAddress='" + homeAddress + '\'' +
                '}';
    }
}