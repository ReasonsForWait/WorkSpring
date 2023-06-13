import React, { useEffect, useState } from "react";
import axios from "axios";

const Comp1 = () => {
  const [hello, setHello] = useState("");

  useEffect(() => {
    axios.get("/api/v1/hello")
    .then(res => setHello(res.data))
    .catch(e => console.log(e))
  });

  return (
    <div>
      <h1>통합 연계 예제</h1>
      <p>백엔드에서 가져온 데이터입니다 : {hello}</p>
    </div>
  )
}

export default Comp1;