import { configureStore } from "@reduxjs/toolkit";

const calcReducer = (state = { result: 0 }, action) => {
    switch (action.type) {
        case "add":
            return {
                result: action.number1 + action.number2
            };
        case "subtract":
            return {
                result: action.number1 - action.number2
            };
        case "multiply":
            return {
                result: action.number1 * action.number2
            };
        case "divide":
            return {
                result: action.number1 / action.number2
            };
        default:
            return state;
    }
};

const store = configureStore({
    reducer: calcReducer
});

export default store;
