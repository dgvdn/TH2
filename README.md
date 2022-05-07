# TH2
- Tạo model với 3 thuộc tính id, des và price
- Tạo class HomeController để chuyển từ trang index sang trang display
- Tạo interface MusicRepository: 	
  Iterable<Music> findAll(); để đọc toàn bộ dữ liệu từ database
	Music findById(String id);  tìm kiếm đối tượng theo id
	Music save(Music music);  thêm mới đối tượng
	Music edit(Music music, String id); sửa đối tượng theo id
	void delete(String id); xóa đối tượng theo id
- Tạo JdbcMusicRepository để thực hiện các chức năng: truy xuất các sản phẩm từ cơ sở dữ liệu, thêm, sửa, xóa sản phẩm.
- Tạo các trang html sử dụng Themeleaf để hiện thị dữ liệu của từng trang add, edit, delete, display.
- Class DisplayController đẩy đối tượng lên trang display.html và chuyển hướng đến các trang khác
- Class AddController thực hiện chức năng thêm đối tượng và trở lại trang display
- Class EditController @GetMapping("/{id}") - lấy id của đối tượng được chọn rồi trích xuất thông tin của đối tượng để hiển thị lên trang edit và thực hiện chức năng sửa.
- Class DeleteController @GetMapping("/{id}") - lấy id của đối tượng được chọn rồi trích xuất thông tin của đối tượng để hiển thị lên trang dellete và thực hiện chức năng xóa.
  Phân công công việc:
  - Nguyễn Tuấn Truyền thiết kế frontend và database, kết nối và đọc dữ liệu từ database, làm AddController
  - Đới Thành Chung thiết kế model, HomeController, DisplayControler
  - Dương Văn Duân tạo EditController, DeleteController, JdbcMusicRepository, MusicRepository (trưởng nhóm)
