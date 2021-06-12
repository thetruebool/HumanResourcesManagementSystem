package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.EmployerService;
import kodlamaio.hrms.core.services.emailCheckServices.EmailCheckServiceBase;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.EmployerDao;

import kodlamaio.hrms.entities.concretes.Employer;

@Service
public class EmployerManager implements EmployerService {

	private EmployerDao employerDao;
	private EmailCheckServiceBase emailCheckService;

	@Autowired
	public EmployerManager(EmployerDao employerDao, EmailCheckServiceBase emailCheckService) {
		this.employerDao = employerDao;
		this.emailCheckService = emailCheckService;
	}

	@Override
	public DataResult<List<Employer>> getAll() {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<Employer>>(employerDao.findAll());
	}

	@Override
	public Result add(Employer employer) {
		if (employer.getCompanyName() == null || employer.getWebsite() == null || employer.getPhoneNumber() == null
				|| employer.getEmail() == null || employer.getPassword() == null
				|| employer.getPasswordRepeat() == null) {
			return new ErrorResult("Fill in blanks");
		}

		
		if(!checkIfEmailMatchesDomain(employer.getWebsite(),employer.getEmail()))
				{
			          	return new ErrorResult("Email and Website doesn't match");
				}

		if (!employer.getPassword().equals(employer.getPasswordRepeat())) {
			return new ErrorResult("Passwords don`t match");
		}
		
	
		
		for(Employer user: employerDao.findAll())
		{
			if(user.getEmail().equals(employer.getEmail()))
				return new ErrorResult("Email has been used");
			
	
		}
		
		
		employerDao.save(employer);
	
		return new SuccessResult("Added");
	}

	private boolean checkIfEmailMatchesDomain(String domain, String email) {

		email = (email.split("@")[1]).toLowerCase();
		
		domain = domain.toLowerCase();

		if (!domain.equals(email)) {
			return false;
		}
		return true;

	}

}
