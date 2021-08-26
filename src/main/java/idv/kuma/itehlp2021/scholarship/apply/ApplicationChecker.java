package idv.kuma.itehlp2021.scholarship.apply;


import java.time.Clock;
import java.time.LocalDate;

public class ApplicationChecker {

    private final ScholarshipRepository scholarshipRepository;

    public ApplicationChecker(ScholarshipRepository scholarshipRepository) {
        this.scholarshipRepository = scholarshipRepository;
    }

    public boolean checkTime(Application application) {

        Scholarship scholarship = scholarshipRepository.find(application.getScholarshipId());

        LocalDate deadline = scholarship.getDeadline();

        LocalDate today = LocalDate.now();

        return today.isEqual(deadline)
                || today.isBefore(deadline);

    }
}
