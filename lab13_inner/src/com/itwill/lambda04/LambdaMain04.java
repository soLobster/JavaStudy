package com.itwill.lambda04;


import java.util.Arrays;
import java.util.List;

public class LambdaMain04 {

    public static void main(String[] args) {
        // 사원들의 리스트: Employee를 원소로 갖는 리스트를 선언, 초기화.
        List<Employee> employees = Arrays.asList(
                new Employee(100, "강동균", "개발1팀", "사원", 1_000),
                new Employee(101, "심채원", "개발2팀", "대리", 900),
                new Employee(200, "김연수", "개발1팀", "대리", 1_100),
                new Employee(201, "임유정", "개발2팀", "과장", 2_000),
                new Employee(300, "박선희", "인사팀", "대리", 1_500),
                new Employee(301, "권오중", "인사팀", "사원", 700)
                );
        
        // 1. 모든 직원들의 정보를 한줄에 한 명씩 출력.
        employees.forEach((x) -> System.out.println(x));
        System.out.println("==================");
        // 2. 개발(1,2팀)에서 일하는 사원들의 급여 합계를 출력.
        List<Double> codingOneTwo = employees.stream()
                .filter((x) -> x.getDept().equals("개발1팀") || x.getDept().equals( "개발2팀"))
                .map((x) -> x.getSalary()).toList();
        
        //System.out.println(codingOne);
        double codingTeamsalSum = 0;
        for(double x : codingOneTwo) {
            codingTeamsalSum += x;
        }
        System.out.println("개발 1,2팀 급여의 합 >> " + codingTeamsalSum);
        
        // 3. 개발팀에서 일하는 사원들의 급여 평균을 출력.
        double salMean = 0;
        int codingTeamempCount = codingOneTwo.size();
        double codingTeamsalMean = codingTeamsalSum/codingTeamempCount;
        System.out.println("개발 1,2팀 급여의 평균 >> " +codingTeamsalMean);
       
        // 4. 직급이 "사원"인 직원들의 급여 합계, 평균을 출력.
        
        List<Double> titleSawon = employees.stream()
                .filter((x) -> x.getEmpTitile().equals("사원"))
                .map((x) -> x.getSalary())
                .toList();
        
        //System.out.println(titleSawon);
        double saWonSalSum = 0;
        for(double x : titleSawon) {
            saWonSalSum += x;
        }
        int saWonCount = titleSawon.size();
        
        double saWonSalMean = saWonSalSum/saWonCount;
        
        System.out.printf("사원들의 연봉 총합 >> %.1f 과 평균 >> %.1f",saWonSalSum,saWonSalMean).println();
        
        // 5. 급여가 1_000을 초과하는 사원들의 정보를 한줄에 한 명씩 출력.
        
        List<Employee> allEmployeesOver1000 = employees.stream().filter((x)-> x.getSalary() > 1_000).toList();
        System.out.println("급여가 1_000을 초과하는 사원들 목록");
        allEmployeesOver1000.forEach((x)->System.out.println(x));
        
        // 6. 개발 1팀 사원들의 급여를 10% 인상하고, 인상한 급여의 평균을 출력.
        List<Double> codingOneTeam = employees.stream().filter((x)-> x.getDept().equals("개발1팀")).map((x)-> x.getSalary()*1.1).toList();
        //System.out.println(codingOneTeam);
        double codingOneTeamSalSum = 0;
        for(double x : codingOneTeam) {
            codingOneTeamSalSum += x;
        }

        int codingOneTeamempCount = codingOneTeam.size();
        double codingOneTeamSalMean = codingOneTeamSalSum/codingOneTeamempCount;
        System.out.println("개발 1팀 인상한 급여의 평균 >> "+codingOneTeamSalMean);
        
        // 7. 직원들 중에서 대리는 몇명 있을까? count 결과 3. 
        System.out.println("직원들 중 대리는 몇명?? >> "+employees.stream().filter((x)-> x.getEmpTitile().equals("대리")).toList().size()+"명");
    }

}
