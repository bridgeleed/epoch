package com.bridgeleed.store.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bridgeleed.store.bean.Address;
import com.bridgeleed.store.bean.ResponseResult;
import com.bridgeleed.store.service.IAddressService;

@RequestMapping("/address")
@Controller
public class AddressController extends BaseController {
	
	@Resource 
	 private IAddressService addressService ;
	
	//��ʾ��ַ����ҳ��
	@RequestMapping("/showAddress.do")
	public String showAddress(){
		
		return "addressAdmin";
	}
	
	
	//�첽��������ջ�����Ϣ
		@RequestMapping("/addAddress.do")
		@ResponseBody
		public ResponseResult<Void> addAddress(
				HttpSession session,
				@RequestParam("receiverName") String recvName,
				@RequestParam("receiverState") String recvProvince,
				@RequestParam("receiverCity") String recvCity,
				@RequestParam("receiverDistrict") String recvArea,
				@RequestParam("receiverAddress") String recvAddress,
				@RequestParam("receiverMobile") String recvPhone,
				@RequestParam("receiverPhone") String recvTel,
				@RequestParam("receiverZip") String recvZip,
				@RequestParam("addressName") String recvTag){
			ResponseResult<Void> rr = 
				new ResponseResult<Void>(1,"�ɹ�");
			Address address = new Address();
			address.setUid(this.getId(session));
			address.setRecvName(recvName);
			address.setRecvProvince(recvProvince);
			address.setRecvCity(recvCity);
			address.setRecvArea(recvArea);
			address.setRecvAddress(recvAddress);
			address.setRecvPhone(recvPhone);
			address.setRecvTel(recvTel);
			address.setRecvZip(recvZip);
			address.setRecvTag(recvTag);
			
			addressService.addAddress(address);
			return rr;
		}
	
	/**
	 * �����ȡ��ַ����
	 * @param session
	 * @return
	 */
	@RequestMapping("/getByUid.do")
	@ResponseBody
	public ResponseResult<List<Address>> getByUid(HttpSession session){
		ResponseResult<List<Address>> rr = new ResponseResult<List<Address>>(1,"�ɹ�");
		List<Address> addresses = addressService.getByUid(this.getId(session));
		rr.setData(addresses);
		return rr;
	}
	
	
	@RequestMapping("/setDefault.do")
	@ResponseBody
	public ResponseResult<Void> setDefault(HttpSession session,Integer id){
		ResponseResult<Void> rr = null;
		try{
			
			rr = new ResponseResult<Void>(1,"�ɹ�");
			addressService.setDefalut(this.getId(session), id);
			
		}catch(RuntimeException ex){
			rr = new ResponseResult<Void>(0,ex.getMessage());
		}
		
		return rr;
	}
	
	@RequestMapping("/goUpdate.do")
	@ResponseBody
	public ResponseResult<Address> goUpdate(Integer id){
		ResponseResult<Address> rr = new ResponseResult<Address>(1,"�ɹ�");
		
		Address address =  addressService.getById(id);
		
		rr.setData(address);
		
		return rr;
	}
	
	@RequestMapping("/updateAddress.do")
	@ResponseBody
	public ResponseResult<Void> updateAddress(
			                                Integer id,
											@RequestParam("receiverName") String recvName,
									        @RequestParam("receiverState") String recvProvince,
											@RequestParam("receiverCity") String recvCity,
											@RequestParam("receiverDistrict") String recvArea,
											@RequestParam("receiverAddress") String recvAddress,
											@RequestParam("receiverMobile") String recvPhone,
											@RequestParam("receiverPhone") String recvTel,
											@RequestParam("receiverZip") String recvZip,
											@RequestParam("addressName") String recvTag){
		
		ResponseResult<Void> rr = new ResponseResult<Void>(1,"�ɹ�");
		Address address = new Address();
		address.setId(id);
		address.setRecvName(recvName);
		address.setRecvProvince(recvProvince);
		address.setRecvCity(recvCity);
		address.setRecvArea(recvArea);
		address.setRecvAddress(recvAddress);
		address.setRecvPhone(recvPhone);
		address.setRecvTel(recvTel);
		address.setRecvZip(recvZip);
		address.setRecvTag(recvTag);
		
		addressService.updateAddress(address);
		return rr;
	}
	
	//����ɾ���ջ��˵�ַ
	@RequestMapping("/removeAddress.do")
	@ResponseBody
	public ResponseResult<Void> removeAddress(Integer id){
		ResponseResult<Void> rr = new ResponseResult<Void>(1,"�ɹ�");
		addressService.removeAddress(id);
		return rr;
		
	}	
	

}
