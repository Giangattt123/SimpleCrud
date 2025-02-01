// import Footer from "./components/Footer";
// import Form from "./components/Form";
// import Header from "./components/Header";

import "./index.css";
import Create from "./pages/Create";
import Update from "./pages/Update";
import Home from "./pages/Home";
// import Test from "./pages/Test";

import { Route, Routes } from "react-router-dom";
import DeleteUser from "./pages/Delete";
function App() {
  return (
    <>
      {/* Test Tailwindcss */}
      {/* <h1 className="bg-blue-500 text-center color-white text-3xl">
        Hello World
      </h1> */}

      <Routes>
        <Route path="/" element={<Home />} />
        <Route path="/create" element={<Create />} />
        <Route path="/update/:username" element={<Update />} />
        <Route path="/delete/:username" element={<DeleteUser />} />
      </Routes>
    </>
  );
}

export default App;
