import React from "react";

const IndianPlayers = () => {
  const team = ["Sachin", "Dhoni", "Virat", "Rohit", "Yuvaraj", "Raina"];
  const [first, second, third, fourth, fifth, sixth] = team;

  const T20Players = [
    "Mr. First Player",
    "Mr. Second Player",
    "Mr. Third Player"
  ];

  const RanjiPlayers = [
    "Mr. Fourth Player",
    "Mr. Fifth Player",
    "Mr. Sixth Player"
  ];

  const mergedPlayers = [...T20Players, ...RanjiPlayers];

  return (
    <div>
      <h2>Odd Players</h2>
      <ul>
        <li>First : {first}1</li>
        <li>Third : {third}3</li>
        <li>Fifth : {fifth}5</li>
      </ul>

      <h2>Even Players</h2>
      <ul>
        <li>Second : {second}2</li>
        <li>Fourth : {fourth}4</li>
        <li>Sixth : {sixth}6</li>
      </ul>

      <h2>List of Indian Players Merged:</h2>
      <ul>
        {mergedPlayers.map((player, index) => (
          <li key={index}>{player}</li>
        ))}
      </ul>
    </div>
  );
};

export default IndianPlayers;
