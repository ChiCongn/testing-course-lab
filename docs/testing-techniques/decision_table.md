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


| Id   | analysisType | dataSize | processingTime | Expected Output           | Actual Output             | Result |
|------|--------------|----------|----------------|---------------------------|---------------------------|--------|
| TC1  | TEXT         | -2.00    | 2              | IllegalArgumentException  | IllegalArgumentException  | Passed |
| TC2  | TEXT         | 0.00     | 4              | IllegalArgumentException  | IllegalArgumentException  | Passed |
| TC3  | TEXT         | 4.00     | -2             | IllegalArgumentException  | IllegalArgumentException  | Passed |
| TC4  | TEXT         | 6.00     | 0              | IllegalArgumentException  | IllegalArgumentException  | Passed |
| TC5  | TEXT         | 8.00     | 1              | 72.00                     | 72.00                     | Passed |
| TC6  | TEXT         | 8.00     | 3              | 60.00                     | 60.00                     | Passed |
| TC7  | TEXT         | 8.00     | 5              | 60.00                     | 60.00                     | Passed |
| TC8  | TEXT         | 8.00     | 9              | 51.00                     | 51.00                     | Passed |
| TC9  | TEXT         | 60.00    | 2              | 484.00                    | 484.00                    | Passed |
| TC10 | TEXT         | 60.00    | 3              | 420.00                    | 420.00                    | Passed |
| TC11 | TEXT         | 60.00    | 6              | 420.00                    | 420.00                    | Passed |
| TC12 | TEXT         | 60.00    | 8              | 372.00                    | 372.00                    | Passed |
| TC13 | IMAGE        | -2.00    | 2              | IllegalArgumentException  | IllegalArgumentException  | Passed |
| TC14 | IMAGE        | 0.00     | 4              | IllegalArgumentException  | IllegalArgumentException  | Passed |
| TC15 | IMAGE        | 4.00     | -2             | IllegalArgumentException  | IllegalArgumentException  | Passed |
| TC16 | IMAGE        | 6.00     | 0              | IllegalArgumentException  | IllegalArgumentException  | Passed |
| TC17 | IMAGE        | 8.00     | 1              | 156.00                    | 156.00                    | Passed |
| TC18 | IMAGE        | 8.00     | 3              | 130.00                    | 130.00                    | Passed |
| TC19 | IMAGE        | 8.00     | 5              | 117.00                    | 117.00                    | Passed |
| TC20 | IMAGE        | 8.00     | 9              | 110.50                    | 110.50                    | Passed |
| TC21 | IMAGE        | 60.00    | 2              | 780.00                    | 780.00                    | Passed |
| TC22 | IMAGE        | 60.00    | 3              | 650.00                    | 650.00                    | Passed |
| TC23 | IMAGE        | 60.00    | 6              | 585.00                    | 585.00                    | Passed |
| TC24 | IMAGE        | 60.00    | 8              | 552.50                    | 552.50                    | Passed |
| TC25 | VIDEO        | -2.00    | 2              | IllegalArgumentException  | IllegalArgumentException  | Passed |
| TC26 | VIDEO        | 0.00     | 4              | IllegalArgumentException  | IllegalArgumentException  | Passed |
| TC27 | VIDEO        | 4.00     | -2             | IllegalArgumentException  | IllegalArgumentException  | Passed |
| TC28 | VIDEO        | 6.00     | 0              | IllegalArgumentException  | IllegalArgumentException  | Passed |
| TC29 | VIDEO        | 8.00     | 1              | 308.00                    | 308.00                    | Passed |
| TC30 | VIDEO        | 8.00     | 3              | 264.00                    | 264.00                    | Passed |
| TC31 | VIDEO        | 8.00     | 5              | 264.00                    | 264.00                    | Passed |
| TC32 | VIDEO        | 8.00     | 9              | 231.00                    | 231.00                    | Passed |
| TC33 | VIDEO        | 60.00    | 2              | 1,200.00                  | 1,200.00                  | Passed |
| TC34 | VIDEO        | 60.00    | 3              | 1,000.00                  | 1,000.00                  | Passed |
| TC35 | VIDEO        | 60.00    | 6              | 1,000.00                  | 1,000.00                  | Passed |
| TC36 | VIDEO        | 60.00    | 8              | 850.00                    | 850.00                    | Passed |
| TC37 | null         | 0.00     | 0              | IllegalArgumentException  | IllegalArgumentException  | Passed |
| TC38 | null         | 2.00     | 2              | IllegalArgumentException  | IllegalArgumentException  | Passed |
| TC39 | null         | 6.00     | 12             | IllegalArgumentException  | IllegalArgumentException  | Passed |
| TC40 | null         | 0.00     | 8              | IllegalArgumentException  | IllegalArgumentException  | Passed |