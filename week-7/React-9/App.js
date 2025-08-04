import React from "react";
import ListOfPlayers from "./components/ListOfPlayers";
import IndianPlayers from "./components/IndianPlayers";

const App = () => {
  const flag = true; // List of Players and those scoring <70.
                    //Make it false to check Indian odd/even players and merged list.

  return (
    <div>
      {flag ? <ListOfPlayers /> : <IndianPlayers />}
    </div>
  );
};

export default App;
