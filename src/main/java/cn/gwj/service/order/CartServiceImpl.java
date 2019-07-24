package cn.gwj.service.order;

import cn.easybuy.service.order.CartService;
import cn.gwj.utils.EmptyUtils;
import cn.gwj.utils.ShoppingCart;
import cn.gwj.utils.ShoppingCartItem;
import org.springframework.stereotype.Service;

@Service
public class CartServiceImpl implements CartService {
	
    @Override
    public ShoppingCart modifyShoppingCart(String productId, String quantityStr, ShoppingCart cart){
    	Integer quantity = 0;
    	if (!EmptyUtils.isEmpty(quantityStr))
            quantity = Integer.parseInt(quantityStr);
        //便利购物车寻找该商品 修改其数量
        for (ShoppingCartItem item : cart.getItems()) {
            if (item.getProduct().getId().toString().equals(productId)) {
                if (quantity == 0 || quantity < 0) {
                    cart.getItems().remove(item);
                    break;
                } else {
                    item.setQuantity(quantity);
                }
            }
        }
        //重新计算金额
        try {
            calculate(cart);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cart;
    }

    /**
     * 核算购物车的金额
     *
     * @param cart
     * @return
     * @throws Exception
     */
    @Override
    public ShoppingCart calculate(ShoppingCart cart){
        double sum = 0.0;
        for (ShoppingCartItem item : cart.getItems()) {
            sum = sum + item.getQuantity() * item.getProduct().getPrice();
            item.setCost(item.getQuantity() * item.getProduct().getPrice());
        }
        cart.setSum(sum);
        return cart;
    }
}
