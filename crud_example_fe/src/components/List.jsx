import { useEffect, useState } from "react";
import {
  IoIosAddCircleOutline,
  IoIosSearch,
  IoIosCreate,
  IoIosTrash,
} from "react-icons/io";
import { Link } from "react-router-dom";

const List = () => {
  const [users, setUsers] = useState([]);

  useEffect(() => {
    fetch("http://localhost:8081/crud/users/")
      .then((res) => res.json())
      .then((data) => setUsers(data))
      .catch((error) => console.error("Error fetching data:", error));
  }, []);

  return (
    <div className="w-[90%] mx-auto p-4">
      <div className="flex justify-between items-center mb-4 p-4 rounded-lg shadow-md ">
        <div className="flex items-center border border-gray-300 rounded-md px-3 py-2 max-w-md">
          <input
            type="text"
            className="outline-none w-full max-w-md"
            placeholder="Search..."
          />
          <IoIosSearch className="text-gray-500 text-xl cursor-pointer hover:text-gray-700" />
        </div>

        <Link to="/create">
          <IoIosAddCircleOutline className="text-blue-600 text-3xl cursor-pointer hover:text-blue-800 transition duration-200" />
        </Link>
      </div>

      <div className="overflow-x-auto">
        <table className="w-full border-collapse border border-gray-300 text-center">
          <thead>
            <tr className="">
              <th className="border px-4 py-2">First Name</th>
              <th className="border px-4 py-2">Last Name</th>
              <th className="border px-4 py-2">Username</th>
              <th className="border px-4 py-2">Email</th>
              <th className="border px-4 py-2">Action</th>
            </tr>
          </thead>
          <tbody>
            {users.length > 0 ? (
              users.map((user, index) => (
                <tr key={index} className="hover:text-yellow-300">
                  <td className="border border-gray-300 px-4 py-2">
                    {user.firstName}
                  </td>
                  <td className="border border-gray-300 px-4 py-2">
                    {user.lastName}
                  </td>
                  <td className="border border-gray-300 px-4 py-2">
                    {user.username}
                  </td>
                  <td className="border border-gray-300 px-4 py-2">
                    {user.email}
                  </td>
                  <td className="border border-gray-300 px-4 py-2 flex justify-center space-x-4">
                    <Link to={`/update/${user.username}`}>
                      <IoIosCreate className="text-green-500 text-xl cursor-pointer hover:text-green-700" />
                    </Link>
                    <Link to={`/delete/${user.username}`}>
                      <IoIosTrash className="text-red-500 text-xl cursor-pointer hover:text-red-700" />
                    </Link>
                  </td>
                </tr>
              ))
            ) : (
              <tr>
                <td
                  colSpan="5"
                  className="border border-gray-300 px-4 py-2 text-gray-500"
                >
                  No data available
                </td>
              </tr>
            )}
          </tbody>
        </table>
      </div>
    </div>
  );
};

export default List;
