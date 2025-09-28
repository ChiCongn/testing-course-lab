# Đặt Vấn Đề: Tính Chi Phí Dịch Vụ AI Phân Tích Dữ Liệu

## 1. Tóm tắt
Bài toán yêu cầu xây dựng chương trình tính **chi phí dịch vụ AI phân tích dữ liệu** dựa trên loại phân tích, khối lượng dữ liệu và thời gian xử lý.  
Đầu ra là **tổng chi phí ($)** làm tròn đến 2 chữ số thập phân.

---

## 2. Đầu vào
- `analysisType`: Loại phân tích (`"text"`, `"image"`, `"video"`).
- `dataSize`: Khối lượng dữ liệu (GB, `double > 0`).
- `processingTime`: Thời gian xử lý (giờ, `int > 0`).

Nếu đầu vào không hợp lệ → ném `IllegalArgumentException`.

---

## 3. Đầu ra
- `totalCost`: Tổng chi phí dịch vụ (`double`, làm tròn 2 chữ số thập phân).

---

## 4. Quy tắc tính chi phí

### 4.1 Chi phí cơ bản
- **Text**: `20 + 5 * dataSize`
- **Image**: `50 + 10 * dataSize`
- **Video**: `100 + 15 * dataSize`

### 4.2 Điều chỉnh theo thời gian xử lý
- `≤ 2 giờ`: Tăng **20%** chi phí.
- `2–6 giờ`: Giữ nguyên.
- `> 6 giờ`: Giảm **15%** chi phí.

### 4.3 Quy tắc đặc biệt
- Nếu **Text** và `dataSize > 50` → cộng thêm **$100**.
- Nếu **Image** và `processingTime > 4` → giảm **10%**.
- Nếu **Video** và `dataSize < 10` → tăng thêm **25%**.