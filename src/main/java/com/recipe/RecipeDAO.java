package com.recipe;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RecipeDAO {

    // Create a new recipe in the database
    public static void addRecipe(Recipe recipe) {
        String sql = "INSERT INTO recipes (title, description, ingredients, instructions) VALUES (?, ?, ?, ?)";

        try (Connection conn = DBUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, recipe.getTitle());
            ps.setString(2, recipe.getDescription());
            ps.setString(3, recipe.getIngredients());
            ps.setString(4, recipe.getInstructions());

            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Get all recipes from the database
    public static List<Recipe> getAllRecipes() {
        List<Recipe> recipes = new ArrayList<>();
        String sql = "SELECT * FROM recipes";

        try (Connection conn = DBUtil.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Recipe recipe = new Recipe(
                        rs.getString("title"),
                        rs.getString("description"),
                        rs.getString("ingredients"),
                        rs.getString("instructions")
                );
                recipe.setId(rs.getInt("id"));
                recipes.add(recipe);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return recipes;
    }
}
