import { useNavigate, useParams } from "react-router-dom";

const DeleteUser = () => {
  const { username } = useParams();
  const navigate = useNavigate();

  const deleteUser = async () => {
    try {
      const response = await fetch(
        `http://localhost:8081/crud/users/delete/${username}`,
        {
          method: "DELETE",
        }
      );

      if (!response.ok) {
        throw new Error("Failed to delete user");
      }

      alert("User deleted successfully!");
      navigate("/");
    } catch (error) {
      console.error("Error deleting user:", error);
      alert("Failed to delete user. Please try again.");
    }
  };

  return (
    <div className="text-center">
      <h2>Are you sure you want to delete this user?</h2>
      <button
        onClick={deleteUser}
        className="bg-red-500 text-white px-4 py-2 rounded"
      >
        Yes, Delete
      </button>
    </div>
  );
};

export default DeleteUser;
