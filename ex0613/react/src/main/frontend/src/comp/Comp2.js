import React, { useState } from "react";
import axios from "axios";

const Comp2 = () => {

  const [message, setMessage] = useState("");

  const responseHandler = ({data}) => {
    setMessage(data);
    return data;
  }

  const errorHandler = ({message}) => {
    setMessage(message);
    return message;
  }

  const onNonCors = () => {
    axios.get("http://localhost:8080/api/v2/non-cors").then(responseHandler).catch(errorHandler);
  }
  
  const onCors = () => {
    axios.get("http://localhost:8080/api/v2/cors").then(responseHandler).catch(errorHandler);
  }
  
  const onNonProxy = () => {
    axios.get("/api/v2/non-proxy").then(responseHandler).catch(errorHandler);
  }
  
  const onProxy = () => {
    axios.get("/api/v2/proxy").then(responseHandler).catch(errorHandler);
  }

  return (
    <div>
      <p>
        {message}
      </p>
      <div>
        <button onClick={onNonCors}>non cors header</button>
        <button onClick={onCors}>cors header</button>
        <button onClick={onNonProxy}>non proxy</button>
        <button onClick={onProxy}>proxy</button>
      </div>
    </div>
  )
}

export default Comp2;