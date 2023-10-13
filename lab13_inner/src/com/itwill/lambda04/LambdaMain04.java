package com.itwill.lambda04;


import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;

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
        System.out.println("1. 모든 직원들의 정보를 한줄에 한 명씩 출력.");
        employees.forEach((x) -> System.out.println(x));
        
        // 2. 개발(1,2팀)에서 일하는 사원들의 급여 합계를 출력.
        System.out.println("2. 개발(1,2팀)에서 일하는 사원들의 급여 합계를 출력.");
        List<Double> codingTeam = employees.stream()
                .filter((x) -> x.getDept().equals("개발1팀") || x.getDept().equals( "개발2팀"))
                .map((x) -> x.getSalary()).toList();
        
      //System.out.println(codingOne);
        double codingTeamSalSum = 0;
        for(double x : codingTeam) {
            codingTeamSalSum += x;
        }
        System.out.println("개발 1,2팀 급여의 합 >> " + codingTeamSalSum);
        
        double condingTeamSalSum2 = employees.stream().filter((x) -> x.getDept().equals("개발1팀") || x.getDept().equals( "개발2팀"))
                .mapToDouble((x) -> x.getSalary()).sum();
        System.out.println("개발 1,2팀 급여의 합(mapToDouble) >> "+condingTeamSalSum2);
        
        // 3. 개발팀에서 일하는 사원들의 급여 평균을 출력.
        System.out.println("3. 개발팀에서 일하는 사원들의 급여 평균을 출력.");
        double codingTeamSalMean = 0;
        int codingTeamEmpCount = codingTeam.size();
        codingTeamSalMean = codingTeamSalSum/codingTeamEmpCount;
        System.out.println("개발 1,2팀 급여의 평균 >> " +codingTeamSalMean);
        
        double codingTeamSalMean2;
        codingTeamSalMean2 = employees.stream().filter((x) -> x.getDept().equals("개발1팀") || x.getDept().equals( "개발2팀"))
                .mapToDouble((x) -> x.getSalary()).average().getAsDouble();
        System.out.println("개발 1,2팀 급여의 평균(avarge().getAsDouble) >> "+codingTeamSalMean2);
        
        // 4. 직급이 "사원"인 직원들의 급여 합계, 평균을 출력.
        System.out.println("4. 직급이 \"사원\"인 직원들의 급여 합계, 평균을 출력.");
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
        
        System.out.printf("사원들의 연봉 총합 = %.1f 과 평균 = %.1f",saWonSalSum,saWonSalMean).println();
        
        double titleSawonMean2 = employees.stream().filter((x) -> x.getEmpTitile().equals("사원")).mapToDouble((x) -> x.getSalary()).average().getAsDouble();
        double titleSawonSum2 = employees.stream().filter((x) -> x.getEmpTitile().equals("사원")).mapToDouble((x) -> x.getSalary()).sum();
        System.out.println("사원들의 연봉 총합(sum()) >> "+titleSawonSum2);
        System.out.println("사원들의 연봉 평균(average().getAsDouble) >> "+titleSawonMean2);
        
        // 5. 급여가 1_000을 초과하는 사원들의 정보를 한줄에 한 명씩 출력.
        System.out.println("5. 급여가 1_000을 초과하는 사원들의 정보를 한줄에 한 명씩 출력.");
        List<Employee> allEmployeesOver1000 = employees.stream().filter((x)-> x.getSalary() > 1_000).toList();
        allEmployeesOver1000.forEach((x)->System.out.println(x));
        
        // 6. 개발 1팀 사원들의 급여를 10% 인상하고, 인상한 급여의 평균을 출력.
        System.out.println("6. 개발 1팀 사원들의 급여를 10% 인상하고, 인상한 급여의 평균을 출력.");
        List<Double> codingOneTeam = employees.stream().filter((x)-> x.getDept().equals("개발1팀")).map((x)-> x.getSalary()*1.1).toList();
        double codingOnTeam2 = employees.stream().filter((x) -> x.getDept().equals("개발1팀")).mapToDouble((x) -> x.getSalary()*1.1).average().getAsDouble();
       
        System.out.println("개발1팀의 인상한 급여의 평균(getAsDouble) >> "+codingOnTeam2);

        //System.out.println(codingOneTeam);
        double codingOneTeamSalSum = 0;
        for(double x : codingOneTeam) {
            codingOneTeamSalSum += x;
        }

        int codingOneTeamempCount = codingOneTeam.size();
        double codingOneTeamSalMean = codingOneTeamSalSum/codingOneTeamempCount;
        System.out.println("개발 1팀의 인상한 급여의 평균 >> "+codingOneTeamSalMean);
        
        // 7. 직원들 중에서 대리는 몇명 있을까? count 결과 3. 
        System.out.println("7. 직원들 중에서 대리는 몇명 있을까?");
        System.out.println("직원들 중 대리는 몇명?? >> "+employees.stream().filter((x)-> x.getEmpTitile().equals("대리")).toList().size()+"명");
    }

}
