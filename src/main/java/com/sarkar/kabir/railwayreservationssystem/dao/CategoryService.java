/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sarkar.kabir.railwayreservationssystem.dao;

import com.sarkar.kabir.railwayreservationssystem.model.Category;
import org.springframework.stereotype.Service;

/**
 *
 * @author User
 */
@Service
public interface CategoryService {
    public String insertCategory(Category cm);

    public String updateCategory(Category cm);

    public String deleteCategory(String id);

    public String viewCategory();

    public Category viewOneCategory(String id);
}
