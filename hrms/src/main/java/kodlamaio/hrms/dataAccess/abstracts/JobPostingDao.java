package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.JobPosting;

public interface JobPostingDao extends JpaRepository<JobPosting, Integer>{

	
	List<JobPosting> getByJobPosition_Title(String title);
	List<JobPosting> getByEmployer_CompanyName(String companyName);
	
	
}
