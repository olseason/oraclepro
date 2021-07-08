package com.javaex.phone;

import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

public class PhoneApp {

	public static void main(String[] args) {

		// 스캐너
		Scanner input = new Scanner(System.in);
		PhoneDao phoneDao = new PhoneDao();

		// 시작
		System.out.println("****************************************");
		System.out.println("*       전화번호 관리 프로그램         *");
		System.out.println("****************************************");

		// DB 가져오기
		List<PersonVo> phoneList = new ArrayList<PersonVo>();

		Boolean loop = true;
		// 반복문
		while (loop) {
			System.out.println("1.리스트  2.등록  3.삭제  4.검색  5.종료");
			System.out.println("----------------------------------------");
			System.out.print(">메뉴번호: ");
			int num = input.nextInt();
			switch (num) {
			// List
			case 1: {
				System.out.println("<1.리스트>");
				//List 출력
				phoneList = phoneDao.getPersonList();
				printList(phoneList);
				System.out.println();
				break;
			}
			//Update
			case 2: {
				//Scanner 등록
				System.out.println("<2.등록>");
				System.out.print(">이름: ");
				String name = input.next();
				System.out.print(">휴대전화: ");
				String hp = input.next();
				System.out.print(">회사전화: ");
				String company = input.next();
				PersonVo uPersonVo = new PersonVo(name, hp, company);
				phoneDao.personInsert(uPersonVo);
				System.out.println("[등록되었습니다.]");
				//List 출력
				phoneList = phoneDao.getPersonList();
				printList(phoneList);
				System.out.println();
				break;
			}
			//Delete
			case 3: {
				//Scanner 삭제
				System.out.println("<3. 삭제>");
				System.out.print(">번호: ");
				int delete = input.nextInt();
				phoneDao.personDelete(delete);
				System.out.println("[삭제되었습니다.]");
				//List 출력
				phoneList = phoneDao.getPersonList();
				printList(phoneList);
				System.out.println();
				break;
			}
			case 4: {
				System.out.println("<4.검색>");
				System.out.print(">이름: ");
				String search = input.next();
				phoneList = phoneDao.personSearch(search);
				printList(phoneList);
				System.out.println();
				break;
			}
			case 5: {
				System.out.println();
				loop = false;
				break;
			}
			default:
				System.out.println("[다시 입력해주세요]");
				System.out.println();
				break;
			}

		}

		System.out.println("****************************************");
		System.out.println("*             감사합니다               *");
		System.out.println("****************************************");

		input.close();

	}

	
	public static void printList(List<PersonVo> personList) {

		for (int i = 0; i < personList.size(); i++) {

			PersonVo personVo = personList.get(i);
			System.out.println(personVo.getPersonId() + ". " + personVo.getName() + "  " + personVo.getHp() + "  "
					+ personVo.getCompany());
		}
	}
}