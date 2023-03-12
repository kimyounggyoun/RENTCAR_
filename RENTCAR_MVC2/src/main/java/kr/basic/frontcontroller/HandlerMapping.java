package kr.basic.frontcontroller;

import java.util.HashMap;

import kr.basic.controller._Controller;
import kr.basic.controller.*;

public class HandlerMapping {
	private HashMap<String, _Controller> mappings;

	public HandlerMapping() {
		mappings = new HashMap<String, _Controller>();
		mappings.put("/main.do", new _MainController());
		mappings.put("/memberLogin.do", new A_memberLoginController());
		mappings.put("/memberLogout.do", new A_memberLogoutController());
		mappings.put("/memberInsert.do", new A_memberInsertController());
		mappings.put("/carAllList.do", new B_carAllListController());
		mappings.put("/carCategoryList.do", new B_carCategoryListController());
		mappings.put("/carReserveInfo.do", new C_carReserveInfoController());
		mappings.put("/carOptionSelect.do", new C_carOptionSelectController());
		mappings.put("/carReserveSelect.do", new C_carReserveSelectController());
		mappings.put("/carReserveResultDel.do", new D_carReserveResultDelController());
		mappings.put("/carReserveResultView.do", new D_carReserveResultViewController());
	}

	public _Controller getController(String key) { // key=>/memberList.do
		return mappings.get(key);
	}
}
