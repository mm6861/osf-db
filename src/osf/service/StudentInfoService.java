package osf.service;

import java.util.List;

import osf.vo.StudentInfoVO;

public interface StudentInfoService {
	public List<StudentInfoVO> selectStudentInfoList();
	public StudentInfoVO selentStudentInfo();
	public int insertStudentInfo(StudentInfoVO si);
	public int updateStudentInfo(StudentInfoVO si);
	public int deleteStudentInfo(StudentInfoVO si);
}
