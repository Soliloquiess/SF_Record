package lab.ssafy.corona.app;

import java.util.ArrayList;
import java.util.List;

import lab.ssafy.corona.medical.CDC;
import lab.ssafy.corona.medical.Hospital;
import lab.ssafy.corona.person.Patient;

public class MainTest {
	
	public static void main(String[] args) {
		// ���� ����
		Hospital univHospital = new Hospital("���к���", 15, "001", 50, 10);
		Hospital localHospital = new Hospital("���׺���", 3, "901", 10, 2);
		
		// ȯ�� ����
		Patient p1 = new Patient("ȯ��1", 42, "010-1111-1111", "ȣ����", "001", true);
		Patient p2 = new Patient("ȯ��2", 30, "010-2222-2222", "����", "901", true);
		
		// ���� Collection
		List<Hospital> hospitalList = new ArrayList<Hospital>();
		hospitalList.add(univHospital);
		hospitalList.add(localHospital);
		
		// ȯ�� Collection
		List<Patient> patientList = new ArrayList<Patient>();
		patientList.add(p1);
		patientList.add(p2);
		
		CDC cdc = new CDC("������������", 200, hospitalList, patientList);
		cdc.about();
		
		// ������ cdc ����
		univHospital.setCdc(cdc);
		localHospital.setCdc(cdc);
								
		// ���ο� ȯ�� ���
		Patient p3 = new Patient("ȯ��3", 33, "010-3333-3333", "��", "001", false);
		univHospital.addPatient(p3);

		// p3 �� ���������� ȯ�ڷ� p3 ���� �õ�
		Patient p4 = new Patient("ȯ��3", 33, "010-3333-3333", "��", "001", false);
		univHospital.removePatient(p4);
		
		cdc.printPatientList();
	}
}
