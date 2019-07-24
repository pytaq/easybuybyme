package cn.gwj.dao;

import cn.gwj.entity.ProductCategory;
import cn.gwj.param.ProductCategoryParam;

import java.util.List;

/**
 * addObject(UserAddress userAddress)
 * getRowList(params)
 * getRowCount(params)
 * getById(Integer id)
 * updateByQuery(params)
 */
public interface ProductCategoryDao{
	/**
	 * 根据id删除商品
	 * @param parseLong
	 */
	void deleteById(Integer parseLong);//删除商品分类
	/**
	 * 根据条件查询商品列表
	 * @param param
	 */
	public List<ProductCategory> queryProductCategorylist(ProductCategoryParam param);
	/**
	 * 根据id查询商品分类
	 * @param id
	 */
	public ProductCategory queryProductCategoryById(Integer id);
	/**
	 * 添加商品分类
	 * @param productCategory
	 */
	public Integer add(ProductCategory productCategory) ;
	/**
	 * 根据参数查询商品分类的数目
	 * @param param
	 */
	public Integer queryProductCategoryCount(ProductCategoryParam param);
	/**
	 * 修改商品分类
	 * @param productCategory
	 */
	public void update(ProductCategory productCategory) ;
}
