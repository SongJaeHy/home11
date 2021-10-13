<<<<<<< HEAD
package org.ict.service;

import org.springframework.stereotype.Service;

@Service
public class SampleSeviceImpl implements SampleService{

	@Override
	public Integer doAdd(String str1, String str2) throws Exception {
		return Integer.parseInt(str1) + Integer.parseInt(str2);
	}

	@Override
	public void introduce() {
		// TODO Auto-generated method stub
		
	}

}
=======
package org.ict.service;

import org.springframework.stereotype.Service;

@Service
public class SampleSeviceImpl implements SampleService{

	@Override
	public Integer doAdd(String str1, String str2) throws Exception {
		return Integer.parseInt(str1) + Integer.parseInt(str2);
	}

	@Override
	public void introduce() {
		// TODO Auto-generated method stub
		
	}

}
>>>>>>> d831fa8731826682cf244d1ae72775f717ba45cc
