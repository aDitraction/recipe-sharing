package com.recipe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.List;

public class RecipeGUI {

    private JFrame frame;
    private JTextField titleField;
    private JTextArea descriptionField, ingredientsField, instructionsField;
    private JTextArea displayArea;
    private JButton addButton, viewButton, clearButton;

    public RecipeGUI() {
        initialize();
    }

    private void initialize() {
        // Create the main frame
        frame = new JFrame("Recipe Sharing Platform");
        frame.setBounds(100, 100, 600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(new BorderLayout());

        // Create a panel to hold form elements (Title, Description, Ingredients, Instructions)
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(6, 2));

        JLabel titleLabel = new JLabel("Recipe Title:");
        titleField = new JTextField();

        JLabel descriptionLabel = new JLabel("Description:");
        descriptionField = new JTextArea(3, 20);
        descriptionField.setLineWrap(true);
        descriptionField.setWrapStyleWord(true);

        JLabel ingredientsLabel = new JLabel("Ingredients:");
        ingredientsField = new JTextArea(3, 20);
        ingredientsField.setLineWrap(true);
        ingredientsField.setWrapStyleWord(true);

        JLabel instructionsLabel = new JLabel("Instructions:");
        instructionsField = new JTextArea(3, 20);
        instructionsField.setLineWrap(true);
        instructionsField.setWrapStyleWord(true);

        // Add elements to the panel
        panel.add(titleLabel);
        panel.add(titleField);
        panel.add(descriptionLabel);
        panel.add(new JScrollPane(descriptionField));
        panel.add(ingredientsLabel);
        panel.add(new JScrollPane(ingredientsField));
        panel.add(instructionsLabel);
        panel.add(new JScrollPane(instructionsField));

        // Buttons for adding and viewing recipes
        addButton = new JButton("Add Recipe");
        viewButton = new JButton("View All Recipes");
        clearButton = new JButton("Clear");

        // Add buttons to the panel
        panel.add(addButton);
        panel.add(viewButton);
        panel.add(clearButton);

        // Text area to display recipes
        displayArea = new JTextArea(10, 40);
        displayArea.setEditable(false);
        displayArea.setLineWrap(true);
        displayArea.setWrapStyleWord(true);
        JScrollPane scrollPane = new JScrollPane(displayArea);

        // Add the panel and the scroll pane to the frame
        frame.getContentPane().add(panel, BorderLayout.NORTH);
        frame.getContentPane().add(scrollPane, BorderLayout.CENTER);

        // Action listeners for buttons
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addRecipe();
            }
        });

        viewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                viewAllRecipes();
            }
        });

        clearButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                clearFields();
            }
        });
    }

    // Add a new recipe
    private void addRecipe() {
        String title = titleField.getText();
        String description = descriptionField.getText();
        String ingredients = ingredientsField.getText();
        String instructions = instructionsField.getText();

        // Check if all fields are filled
        if (title.isEmpty() || description.isEmpty() || ingredients.isEmpty() || instructions.isEmpty()) {
            JOptionPane.showMessageDialog(frame, "Please fill all fields!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Create a new Recipe object and add it to the database
        Recipe recipe = new Recipe(title, description, ingredients, instructions);
        RecipeDAO.addRecipe(recipe);

        // Clear fields after adding the recipe
        clearFields();
        JOptionPane.showMessageDialog(frame, "Recipe added successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
    }

    // View all recipes
    private void viewAllRecipes() {
        List<Recipe> recipes = RecipeDAO.getAllRecipes();
        displayArea.setText(""); // Clear the display area

        if (recipes.isEmpty()) {
            displayArea.append("No recipes available.\n");
        } else {
            for (Recipe recipe : recipes) {
                displayArea.append(recipe.toString() + "\n\n");
            }
        }
    }

    // Clear the form fields
    private void clearFields() {
        titleField.setText("");
        descriptionField.setText("");
        ingredientsField.setText("");
        instructionsField.setText("");
    }

    // Show the frame
    public void show() {
        frame.setVisible(true);
    }

    // Main method to start the application
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                RecipeGUI window = new RecipeGUI();
                window.show();
            }
        });
    }
}
