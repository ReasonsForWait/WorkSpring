import { Link, Route, Routes} from "react-router-dom";
import Intro from "./Intro";
import Home from "./Home";
import About from "./About";

const Comp3 = () => {
  return (
    <div>
      <h1>Comp3 페이지 이동</h1>
      <ul>
        <li><Link to={"/"}>Intro</Link></li>
        <li><Link to={"/home"}>home</Link></li>
        <li><Link to={"/about"}>about</Link></li>
      </ul>
      <Routes>
        <Route path={"/"} element={<Intro></Intro>}></Route>
        <Route path={"home"} element={<Home></Home>}></Route>
        <Route path={"about"} element={<About></About>}></Route>
        <Route path={"*"} element={<h1>잘못된호출</h1>}></Route>
      </Routes>
    </div>
  )
}

export default Comp3;