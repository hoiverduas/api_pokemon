
import './Header.css'

const Header = () => {

  return (
    <header className="cabecera">
      <div className="logo">
        <img src="/imagenes/pokemon.png" alt="Logo" />
      </div>
      <div className="titulo">
        <h1>Atrápalos a Todos: ¡La Aventura Pokémon Comienza Aquí!</h1>
      </div>
    </header>
  );
};

export default Header;
