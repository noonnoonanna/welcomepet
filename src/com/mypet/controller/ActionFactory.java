package com.mypet.controller;

import com.mypet.admin.controller.action.AdminIndexAction;
import com.mypet.admin.controller.action.AdminLoginAction;
import com.mypet.admin.controller.action.AdminLogoutAction;
import com.mypet.admin.controller.action.AdminMemberListAction;
import com.mypet.admin.controller.action.AdminMtmDeleteAction;
import com.mypet.admin.controller.action.AdminMtmDetailAction;
import com.mypet.admin.controller.action.AdminMtmListAction;
import com.mypet.admin.controller.action.AdminMtmResaveAction;
import com.mypet.admin.controller.action.AdminMtmUpdateAction;
import com.mypet.admin.controller.action.AdminMtmUpdateFormAction;
import com.mypet.admin.controller.action.AdminOrderCancelListAction;
import com.mypet.admin.controller.action.AdminOrderCntListAction;
import com.mypet.admin.controller.action.AdminOrderListAction;
import com.mypet.admin.controller.action.AdminOrderRankListAction;
import com.mypet.admin.controller.action.AdminOrderSaveAction;
import com.mypet.admin.controller.action.AdminOrderSaveFinishAction;
import com.mypet.admin.controller.action.AdminOrdercateListAction;
import com.mypet.admin.controller.action.AdminOrderodNumListAction;
import com.mypet.admin.controller.action.AdminProductDetailAction;
import com.mypet.admin.controller.action.AdminProductListAction;
import com.mypet.admin.controller.action.AdminProductSearchAction;
import com.mypet.admin.controller.action.AdminProductUpdateAction;
import com.mypet.admin.controller.action.AdminProductUpdateFormAction;
import com.mypet.admin.controller.action.AdminProductWriteAction;
import com.mypet.admin.controller.action.AdminProductWriteFormAction;
import com.mypet.admin.controller.action.AdminQnaDeleteAction;
import com.mypet.admin.controller.action.AdminQnaListAction;
import com.mypet.admin.controller.action.AdminQnaUpdateAction;
import com.mypet.admin.controller.action.AdminQnaUpdateFormAction;
import com.mypet.admin.controller.action.AdminQnaViewAction;
import com.mypet.admin.controller.action.AdminQnaWriteAction;
import com.mypet.admin.controller.action.AdminQnaWriteFormAction;
import com.mypet.controller.action.Action;
import com.mypet.controller.action.BirdIndexAction;
import com.mypet.controller.action.CartDeleteAction;
import com.mypet.controller.action.CartInsertAction;
import com.mypet.controller.action.CartListAction;
import com.mypet.controller.action.ContractAction;
import com.mypet.controller.action.DogIndexAction;
import com.mypet.controller.action.IdCheckFormAction;
import com.mypet.controller.action.IndexAction;
import com.mypet.controller.action.JoinAction;
import com.mypet.controller.action.JoinFormAction;
import com.mypet.controller.action.JoinRemoveAction;
import com.mypet.controller.action.JoinSuccessAction;
import com.mypet.controller.action.LoginAction;
import com.mypet.controller.action.LoginFormAction;
import com.mypet.controller.action.LogoutAction;
import com.mypet.controller.action.MtmDeleteAction;
import com.mypet.controller.action.MtmListAction;
import com.mypet.controller.action.MtmUpdateAction;
import com.mypet.controller.action.MtmUpdateFormAction;
import com.mypet.controller.action.MtmViewAction;
import com.mypet.controller.action.MtmWriteAction;
import com.mypet.controller.action.MtmWriteFormAction;
import com.mypet.controller.action.MyPageAction;
import com.mypet.controller.action.OrderAllAction;
import com.mypet.controller.action.OrderCancleAction;
import com.mypet.controller.action.OrderDetailAction;
import com.mypet.controller.action.OrderDirectFormAction;
import com.mypet.controller.action.OrderDirectInsertAction;
import com.mypet.controller.action.OrderFormAction;
import com.mypet.controller.action.OrderInsertAction;
import com.mypet.controller.action.OrderListAction;
import com.mypet.controller.action.ProductDetailAction;
import com.mypet.controller.action.ProductKindAction;
import com.mypet.controller.action.QnaListAction;
import com.mypet.controller.action.QnaViewAction;
import com.mypet.controller.action.RepIndexAction;
import com.mypet.controller.action.ReviewInsertAction;
import com.mypet.controller.action.ReviewUpdateAction;
import com.mypet.controller.action.ReviewUpdateFormAction;
import com.mypet.controller.action.ReviewWriteAction;
import com.mypet.controller.action.SearchAction;
import com.mypet.controller.action.UserUpdateAction;
import com.mypet.controller.action.UserUpdateFormAction;
import com.mypet.controller.action.CatIndexAction;
public class ActionFactory {

	//싱글톤 패턴 만들기
	private ActionFactory() { }
	private static ActionFactory instance = new ActionFactory();
	public static ActionFactory getInstance() {
		return instance;
	}

	public Action getAction(String command) {
		Action action = null;
		System.out.println("ActionFactory  : " + command);

		//command 값에 따라서 행동 페이지로 이동
		if (command.equals("index")) {
			action = new IndexAction();
		}else if (command.equals("search")) {
			action = new SearchAction();
		}else if(command.equals("cat")) {
			action = new CatIndexAction();
		}else if(command.equals("dog")) {
			action = new DogIndexAction();
		}else if(command.equals("rep")) {
			action = new RepIndexAction();
		}else if(command.equals("bird")) {
			action = new BirdIndexAction();
		}else if (command.equals("contract")) {
			action = new ContractAction();
		}else if (command.equals("join_form")) {
			action = new JoinFormAction();
		}else if (command.equals("join")) {
			action = new JoinAction();
		}else if (command.equals("joinSuccess")) {
			action = new JoinSuccessAction();
		}else if (command.equals("id_check_form")) {
			action = new IdCheckFormAction();
		}else if (command.equals("login_form")) {
			action = new LoginFormAction();
		}else if (command.equals("login")) { 
			action = new LoginAction();
		}else if (command.equals("logout")) {
			action = new LogoutAction();
		}else if (command.equals("cart_insert")) {
			action = new CartInsertAction();
		}else if (command.equals("cart_list")) {
			action = new CartListAction();
		}else if (command.equals("cart_delete")) {
			action = new CartDeleteAction();
		}else if (command.equals("order_insert")) {
			action = new OrderInsertAction();
		}else if (command.equals("order_direct_insert")) {
			action = new OrderDirectInsertAction();
		}else if (command.equals("order_list")) {
			action = new OrderListAction();
		}else if (command.equals("mypage")) {
			action = new MyPageAction();
		}else if (command.equals("order_detail")) {
			action = new OrderDetailAction();	
		}else if (command.equals("order_all")) {
			action = new OrderAllAction();
		}else if (command.equals("product_detail")){
			action = new ProductDetailAction();
		}else if (command.equals("product_kind")){
			action = new ProductKindAction();
		}else if (command.equals("review_write")) {
			action = new ReviewWriteAction();
		}else if (command.equals("review_insert")) {
			action = new ReviewInsertAction();
		}else if (command.equals("review_update_form")) {
			action = new ReviewUpdateFormAction();
		}else if (command.equals("review_update")) {
			action = new ReviewUpdateAction();
		}else if (command.equals("update_user")) {
			action = new UserUpdateAction();
		}else if (command.equals("update_user_form")) {
			action = new UserUpdateFormAction();
		}else if (command.equals("order_cancle")) {
			action = new OrderCancleAction();
		}else if (command.equals("order_form")) {
			action = new OrderFormAction();
		}else if (command.equals("order_direct_form")) {
			action = new OrderDirectFormAction();
		}else if (command.equals("mtm_update")) {	
			action = new MtmUpdateAction();
		}else if (command.equals("mtm_update_form")) {
			action = new MtmUpdateFormAction();
		}else if (command.equals("mtm_list")) {
			action = new MtmListAction();
		}else if (command.equals("mtm_write")) {
			action = new MtmWriteAction();
		}else if (command.equals("mtm_write_form")) {
			action = new MtmWriteFormAction();
		}else if (command.equals("mtm_view")) {
			action = new MtmViewAction();
		}else if (command.equals("mtm_delete")) {
			action = new MtmDeleteAction();
		}else if (command.equals("qna_delete")) {
			action = new AdminQnaDeleteAction();
		}else if (command.equals("admin_login_form")) {
			action = new AdminIndexAction();
		}else if (command.equals("admin_login")) {
			action = new AdminLoginAction();
		} else if (command.equals("admin_logout")) {
			action = new AdminLogoutAction();
		} else if (command.equals("admin_product_list")) {
			action = new AdminProductListAction();
		} else if (command.equals("admin_product_write_form")) {
			action = new AdminProductWriteFormAction();
		} else if (command.equals("admin_product_write")) {
			action = new AdminProductWriteAction();
		} else if (command.equals("admin_product_detail")) {
			action = new AdminProductDetailAction();
		} else if (command.equals("admin_product_update_form")) {
			action = new AdminProductUpdateFormAction();
		} else if (command.equals("admin_product_update")) {
			action = new AdminProductUpdateAction();
		} else if (command.equals("admin_order_list")) {
			action = new AdminOrderListAction();
		} else if (command.equals("admin_cancel_order_list")) {
			action = new AdminOrderCancelListAction();
		} else if (command.equals("admin_order_save_finish")) {
			action = new AdminOrderSaveFinishAction();
		} else if (command.equals("admin_member_list")) {
			action = new AdminMemberListAction();
		}else if (command.equals("admin_product_search")) {
			action = new AdminProductSearchAction();
		} else if (command.equals("admin_order_save")) {
			action= new AdminOrderSaveAction();
		} else if (command.equals("admin_mtm_list")) {
			action = new AdminMtmListAction();
		} else if (command.equals("admin_mtm_detail")) {
			action = new AdminMtmDetailAction();
		} else if (command.equals("admin_mtm_repsave")) {
			action = new AdminMtmResaveAction();
		} else if (command.equals("admin_mtm_delete")) {
			action = new AdminMtmDeleteAction();
		} else if (command.equals("admin_mtm_update_form")) {
			action = new AdminMtmUpdateFormAction();
		} else if (command.equals("admin_mtm_update")) {
			action = new AdminMtmUpdateAction();
		}else if (command.equals("admin_qna_list")) {
			action = new AdminQnaListAction();
		}else if (command.equals("qna_write_form")) {
			action = new AdminQnaWriteFormAction();
		}else if (command.equals("qna_write")) {
			action = new AdminQnaWriteAction();
		}else if (command.equals("admin_qna_view")) {
			action = new AdminQnaViewAction();
		}else if (command.equals("qna_update_form")) {
			action = new AdminQnaUpdateFormAction();
		}else if (command.equals("qna_update")) {
			action = new AdminQnaUpdateAction();
		}else if (command.equals("qna_list")) {
			action = new QnaListAction();
		}else if (command.equals("qna_view")) {
			action = new QnaViewAction();
		} else if (command.equals("order_Cntlist")) {
			action = new AdminOrderCntListAction();
		} else if (command.equals("order_Ranklist")) {
			action = new AdminOrderRankListAction();
		} else if (command.equals("order_odNumlist")) {
			action = new AdminOrderodNumListAction();
		} else if (command.equals("order_catelist")) {
			action = new AdminOrdercateListAction();
		}else if (command.equals("join_remove")) {
	         action = new JoinRemoveAction();
	      }
		return action; 
	}

}