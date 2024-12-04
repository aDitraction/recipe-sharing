const searchBox = document.querySelector('.searchBox');
const searchButton = document.querySelector('.searchButton');
const recipeContainer = document.querySelector('.recipe-container');
const recipeCloseBtn = document.querySelector('.recipe-close-btn');
const recipeDetailsContent = document.querySelector('.recipe-details-content');

// FetchingRecipies
const fetchRecipes = async (query) => {
    recipeContainer.innerHTML ="Fetching recipes...";
    const data = await fetch(`https://www.themealdb.com/api/json/v1/1/search.php?s=${query}`);
    const response = await data.json();
    // if (Object.keys(response).length==0){

    // }
    // console.log(response);
    recipeContainer.innerHTML ="";
    try{

        response.meals.forEach(meal => {
            // console.log(meal)
            const recipeDiv  = document.createElement('div');
            recipeDiv.classList.add('recipie');
            recipeDiv.innerHTML=`
            <img src= "${meal.strMealThumb}">
            <h3>${meal.strMeal}</h3>
            <p><span>${meal.strArea}</span></p>
            <p><span>${meal.strCategory}</span></p>
            `;
            const button =document.createElement('button');
            button.textContent="View Recipe";

            recipeDiv.appendChild(button);

            //Evnt listner for view recipe button
            button.addEventListener('click',()=>{
                openRecipePopup(meal);
            });

            recipeContainer.appendChild(recipeDiv);
        });
    }catch(e){
        recipeContainer.innerHTML = "<h2>No meals found.</h2>";
    }

}

const fetchIngredients = (meal) =>{
    let ingredientsList = "";
    for(let i=1;i<=20;i++){
        const ingredients = meal[`strIngredient${i}`];
        if(ingredients){
            const measure = meal[`strMeasure${i}`];
            ingredientsList += `<li>${measure} ${ingredients}</li>`;
        }
        else{
            console.log(ingredientsList);
            break;
        }

    }
    return ingredientsList;
};

const openRecipePopup = (meal) => {
    recipeDetailsContent.innerHTML = `
    <h2 class="recipeName">${meal.strMeal}</h2>
    <h3>Ingredients:</h3>
    <ul class="recipieIngredientList">${fetchIngredients(meal)}</ul>
    <div class="recipeInstructions">
        <h3>Instructions:</h3>
        <p>${meal.strInstructions}</p>
    </div>
    `;
    
    
    recipeDetailsContent.parentElement.style.display = "block";
};


recipeCloseBtn.addEventListener('click',() =>{
    recipeDetailsContent.parentElement.style.display="none";
});
searchButton.addEventListener('click',(e)=>{
    e.preventDefault();
    const searchInput = searchBox.value.trim();
    fetchRecipes(searchInput);
    // console.log("button Clicked");
});