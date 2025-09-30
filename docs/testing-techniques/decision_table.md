# Decision Table

## Xác định điều kiện và hành động

### Điều kiện (Conditions)

- **C1**: `analysisType = null`  
- **C2**: `analysisType = TEXT`  
- **C3**: `analysisType = IMAGE`  
- **C4**: `analysisType = VIDEO`  
- **C5**: `dataSize <= 0`  
- **C6**: `dataSize < 10`  
- **C7**: `dataSize > 50`  
- **C8**: `processingTime <= 0`  
- **C9**: `processingTime <= 2`  
- **C10**: `2 < processingTime <= 4`  
- **C11**: `4 < processingTime <= 6`  
- **C12**: `processingTime > 6`  

### Hành động (Actions)

- **E1**: Tính chi phí cơ bản  
- **E2**: Tăng 20%  
- **E3**: Giảm 15%  
- **E4**: Cộng thêm $100  
- **E5**: Giảm thêm 10%  
- **E6**: Tăng thêm 25%  
- **E7**: Ném `IllegalArgumentException` (Input không hợp lệ)  

## Bảng quyết định [🔗](https://docs.google.com/spreadsheets/d/1K-PVUDy2B0zqHSDl13efD_TSm8MoxEnUIZiygHeRkzs/edit?usp=sharing) 


## Test report
Bảng dưới đây liệt kê kết quả kiểm thử cho phương thức `calculateCost` của lớp `AICostCalculator`, bao gồm 40 trường hợp kiểm thử với đầu vào, kết quả kỳ vọng, kết quả thực tế và trạng thái.


| Id   | analysisType | dataSize | processingTime | Expected Output           | Actual Output | Result |
|------|--------------|----------|----------------|---------------------------|---------------|--------|
| TC1  | TEXT         | -2.00    | 2              | IllegalArgumentException  |               |        |
| TC2  | TEXT         | 0.00     | 4              | IllegalArgumentException  |               |        |
| TC3  | TEXT         | 4.00     | -2             | IllegalArgumentException  |               |        |
| TC4  | TEXT         | 6.00     | 0              | IllegalArgumentException  |               |        |
| TC5  | TEXT         | 8.00     | 1              | 72.00                     |               |        |
| TC6  | TEXT         | 8.00     | 3              | 60.00                     |               |        |
| TC7  | TEXT         | 8.00     | 5              | 60.00                     |               |        |
| TC8  | TEXT         | 8.00     | 9              | 51.00                     |               |        |
| TC9  | TEXT         | 60.00    | 2              | 484.00                    |               |        |
| TC10 | TEXT         | 60.00    | 3              | 420.00                    |               |        |
| TC11 | TEXT         | 60.00    | 6              | 420.00                    |               |        |
| TC12 | TEXT         | 60.00    | 8              | 372.00                    |               |        |
| TC13 | IMAGE        | -2.00    | 2              | IllegalArgumentException  |               |        |
| TC14 | IMAGE        | 0.00     | 4              | IllegalArgumentException  |               |        |
| TC15 | IMAGE        | 4.00     | -2             | IllegalArgumentException  |               |        |
| TC16 | IMAGE        | 6.00     | 0              | IllegalArgumentException  |               |        |
| TC17 | IMAGE        | 8.00     | 1              | 156.00                    |               |        |
| TC18 | IMAGE        | 8.00     | 3              | 130.00                    |               |        |
| TC19 | IMAGE        | 8.00     | 5              | 117.00                    |               |        |
| TC20 | IMAGE        | 8.00     | 9              | 110.50                    |               |        |
| TC21 | IMAGE        | 60.00    | 2              | 780.00                    |               |        |
| TC22 | IMAGE        | 60.00    | 3              | 650.00                    |               |        |
| TC23 | IMAGE        | 60.00    | 6              | 585.00                    |               |        |
| TC24 | IMAGE        | 60.00    | 8              | 552.50                    |               |        |
| TC25 | VIDEO        | -2.00    | 2              | IllegalArgumentException  |               |        |
| TC26 | VIDEO        | 0.00     | 4              | IllegalArgumentException  |               |        |
| TC27 | VIDEO        | 4.00     | -2             | IllegalArgumentException  |               |        |
| TC28 | VIDEO        | 6.00     | 0              | IllegalArgumentException  |               |        |
| TC29 | VIDEO        | 8.00     | 1              | 308.00                    |               |        |
| TC30 | VIDEO        | 8.00     | 3              | 264.00                    |               |        |
| TC31 | VIDEO        | 8.00     | 5              | 264.00                    |               |        |
| TC32 | VIDEO        | 8.00     | 9              | 231.00                    |               |        |
| TC33 | VIDEO        | 60.00    | 2              | 1,200.00                  |               |        |
| TC34 | VIDEO        | 60.00    | 3              | 1,000.00                  |               |        |
| TC35 | VIDEO        | 60.00    | 6              | 1,000.00                  |               |        |
| TC36 | VIDEO        | 60.00    | 8              | 850.00                    |               |        |
| TC37 | null         | 0.00     | 0              | IllegalArgumentException  |               |        |
| TC38 | null         | 2.00     | 2              | IllegalArgumentException  |               |        |
| TC39 | null         | 6.00     | 12             | IllegalArgumentException  |               |        |
| TC40 | null         | 0.00     | 8              | IllegalArgumentException  |               |        |