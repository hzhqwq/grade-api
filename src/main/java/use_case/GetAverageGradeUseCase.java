package use_case;
import api.GradeDB;
import entity.Grade;
import entity.Team;

public final class GetAverageGradeUseCase {
    private final GradeDB gradeDB;

    public GetAverageGradeUseCase(GradeDB gradeDB) {
        this.gradeDB = gradeDB;
    }

    public float getAverageGrade(String course) {
        // TODO: Get average grade for all students in your team.
        String[] team = this.gradeDB.getMyTeam().getMembers();
        float total_grade = 0;
        int total_member = 0;
        for (String i: team){
            total_member += 1;
            total_grade += this.gradeDB.getGrade(i, course).getGrade();
        }
        return total_grade/total_member;
    }
}
