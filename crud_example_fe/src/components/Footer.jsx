// import React from "react";
import { BsEmojiSmileUpsideDown } from "react-icons/bs";

const handleSpanClick = () => {
  window.open("https://github.com/Giangattt123/", "_blank");
};

const Footer = () => {
  return (
    <div className="w-[90%] h-[120px] my-10 rounded-xl bg-[#2d3748] mx-auto flex justify-center items-center selection:bg-white selection:text-[#0b1623]">
      <p className="text-white font-Consolas">
        made by{" "}
        <span
          onClick={handleSpanClick}
          className="font-bold cursor-pointer underline hover:text-[#d6ba8f] duration-300"
        >
          Phùng Đức Giang
        </span>
        <BsEmojiSmileUpsideDown className="inline ml-1" />
        <br />
      </p>
    </div>
  );
};

export default Footer;
