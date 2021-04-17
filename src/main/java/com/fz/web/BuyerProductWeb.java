package com.fz.web;

import com.fz.VO.ProductInfoVO;
import com.fz.VO.ProductVo;
import com.fz.VO.ResultVO;
import com.fz.pojo.ProductCategory;
import com.fz.pojo.ProductInfo;
import com.fz.service.CategoryService;
import com.fz.service.ProductService;
import com.fz.utils.ResultVOUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author: FZ
 * @date: 2021/4/15 20:23
 * @description:
 */

@RestController
@RequestMapping("/buyer/product")
public class BuyerProductWeb {

    @Autowired
    private CategoryService categoryService;
    @Autowired
    private ProductService productService;

    @GetMapping("/list")
    public ResultVO list() {
        //查询所有的上架商品
        List<ProductInfo> productInfoList = productService.findUpAll();
        //查询类目
        List<Integer> categoryTypeList = productInfoList.stream()
                .map(e -> e.getCategoryType())
                .collect(Collectors.toList());

        List<ProductCategory> productCategoryList = categoryService.findByCategoryTypeIn(categoryTypeList);
//        ArrayList<Integer> categoryList = new ArrayList<>( );
//
//        List<ProductVo> productVoList = new ArrayList<>( );
//        for (ProductInfo productInfo : productInfoList) {
//            categoryList.add(productInfo.getCategoryType());
//        }
        //数据拼装

        List<ProductVo> productVOList = new ArrayList<>();
        for (ProductCategory productCategory : productCategoryList) {
            ProductVo productVO = new ProductVo();
            productVO.setCategoryType(productCategory.getCategoryType());
            productVO.setCategoryName(productCategory.getCategoryName());

            List<ProductInfoVO> productInfoVOList = new ArrayList<>();
            for (ProductInfo productInfo : productInfoList) {
                if (productInfo.getCategoryType().equals(productCategory.getCategoryType())) {
                    ProductInfoVO productInfoVO = new ProductInfoVO();
                    BeanUtils.copyProperties(productInfo, productInfoVO);
                    productInfoVOList.add(productInfoVO);
                }
            }
            productVO.setProductInfoVOList(productInfoVOList);
            productVOList.add(productVO);
        }
        return ResultVOUtil.success( productVOList );

    }


}
