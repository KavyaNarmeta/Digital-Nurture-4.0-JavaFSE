import React, { useState } from "react";
import CurrencyConverter from "./CurrencyConverter";

const App = () => {
  const [count, setCount] = useState(5);

  const handleIncrement = () => {
    increment();
    sayHello();
  };

  const increment = () => {
    setCount(count + 1);
  };

  const sayHello = () => {
    alert("Hello! Member1");
  };

  const handleDecrement = () => {
    setCount(count - 1);
  };

  const sayWelcome = (msg) => {
    alert(msg);
  };

  const handleClick = (e) => {
    alert("I was clicked");
  };

  return (
    <div style={{ margin: "20px" }}>
      <p>{count}</p>
      <button onClick={handleIncrement}>Increment</button>
      <br />
      <button onClick={handleDecrement}>Decrement</button>
      <br />
      <button onClick={() => sayWelcome("welcome")}>Say welcome</button>
      <br />
      <button onClick={handleClick}>Click on me</button>

      <hr />
      <CurrencyConverter />
    </div>
  );
};

export default App;
