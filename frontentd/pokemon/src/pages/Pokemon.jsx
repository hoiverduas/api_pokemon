import React, { useState, useEffect } from "react";
import Header from '../components/Header';
import './Pokemon.css';

const Pokemon = () => {
  const [trainers, setTrainers] = useState([]);

  const fetchTrainers = async () => {
    try {
      const response = await fetch("http://localhost:9091/api/trainers/allTrainers");
      const data = await response.json();
      setTrainers(data);
    } catch (error) {
      console.error("Error al traer los entrenadores:", error);
    }
  };

  useEffect(() => {
    fetchTrainers();
  }, []);

  return (
    <>
      <div className="barraFija">
        <Header />
      </div>
      <section>
        <div>
          <h1>Entrenadores Pokémon</h1>
          <table className="tabla">
            <thead>
              <tr>
                <th>Nombre del Entrenador</th>
                <th>Ciudad</th>
                <th>Pokémones Favoritos</th>
                <th>Puntuación</th>
              </tr>
            </thead>
            <tbody>
              {trainers.map((trainer) => (
                <tr key={trainer.id}>
                  <td>{trainer.name}</td>
                  <td>{trainer.city}</td>
                  <td>{trainer.favoritePokemons.join(", ")}</td>
                  <td>{trainer.score}</td>
                </tr>
              ))}
            </tbody>
          </table>
        </div>
      </section>
    </>
  );
};

export default Pokemon;
