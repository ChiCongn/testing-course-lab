# Phân Tích Giá Trị Biên

## Phân tích các tham số đầu vào

### 1. `analysisType` (Kiểu liệt kê: TEXT, IMAGE, VIDEO, null)
- **Giá trị biên**:
  - Hợp lệ: `TEXT`, `IMAGE`, `VIDEO`.
  - Không hợp lệ: `null`.

### 2. `dataSize` (double, > 0)
- **Miền giá trị**:
  - Hợp lệ: `dataSize > 0` (theo yêu cầu, min = 0.01).
  - Không hợp lệ: `dataSize <= 0`.
  - Không có giới hạn trên (upper bound) trong code hiện tại.
- **Giá trị biên**:
  - **min-, min, min+**: `0.00`, `0.01`, `0.02`.
  - **max-, max, max+**: Vì không có giới hạn trên, chọn:
    - `1,000,000.00` (giá trị lớn thực tế, kiểm tra chi phí cao).
    - `Double.MAX_VALUE` (giá trị lớn nhất của `double`, kiểm tra hành vi với số cực đại).
  - **Nominal (nom)**: `12.50` (giá trị trung bình, đại diện cho trường hợp thông thường).

### 3. `processingTime` (int)
- **Miền giá trị**:
  - Hợp lệ: `processingTime > 0`.
  - Không hợp lệ: `processingTime <= 0`.
  - Không có giới hạn trên (upper bound) trong code hiện tại.
- **Giá trị biên**:
  - **min-, min, min+**: `0` (không hợp lệ), `1` (hợp lệ nhỏ nhất), `2` (hơi lớn hơn min, kiểm tra ngưỡng tăng 20%).
  - **max-, max, max+**: Vì không có giới hạn trên, chọn:
    - `1,000,000` (giá trị lớn thực tế, kiểm tra chi phí giảm 15%).
    - `Integer.MAX_VALUE` (giá trị lớn nhất của `int`, kiểm tra hành vi với số cực đại).
  - **Nominal (nom)**: `8` (giá trị trung bình, kiểm tra ngưỡng giảm 15%).

## Bảng test case

| Id       | analysisType | dataSize          | processingTime     | Expected Output           | Actual Output            | Result |
|----------|--------------|-------------------|--------------------|---------------------------|--------------------------|--------|
| BVA-TC1  | TEXT         | 0.00              | 8                  | IllegalArgumentException  | IllegalArgumentException | Passed |
| BVA-TC2  | TEXT         | 0.01              | 8                  | 17.04                     | 17.04                    | Passed |
| BVA-TC3  | TEXT         | 0.02              | 8                  | 17.09                     | 17.09                    | Passed |
| BVA-TC4  | TEXT         | 999,999.99        | 8                  | 4,250,116.96              | 4,250,116.96             | Passed |
| BVA-TC5  | TEXT         | 1,000,000.00      | 8                  | 4,250,117.00              | 4,250,117.00             | Passed |
| BVA-TC6  | TEXT         | 1,000,000.01      | 8                  | IllegalArgumentException  | IllegalArgumentException | Passed |
| BVA-TC7  | TEXT         | 12.50             | 8                  | 70.13                     | 70.13                    | Passed |
| BVA-TC8  | TEXT         | 12.50             | 0                  | IllegalArgumentException  | IllegalArgumentException | Passed |
| BVA-TC9  | TEXT         | 12.50             | 1                  | 99.00                     | 99.00                    | Passed |
| BVA-TC10 | TEXT         | 12.50             | 2                  | 99.00                     | 99.00                    | Passed |
| BVA-TC11 | TEXT         | 12.50             | 1,000,000          | 70.13                     | 70.13                    | Passed |
| BVA-TC12 | TEXT         | 12.50             | Integer.MAX_VALUE  | 70.13                     | 70.13                    | Passed |
| BVA-TC13 | IMAGE        | 0.00              | 8                  | IllegalArgumentException  | IllegalArgumentException | Passed |
| BVA-TC14 | IMAGE        | 0.01              | 8                  | 42.59                     | 42.59                    | Passed |
| BVA-TC15 | IMAGE        | 0.02              | 8                  | 42.67                     | 42.67                    | Passed |
| BVA-TC16 | IMAGE        | 999,999.99        | 8                  | 8,500,042.42              | 8,500,042.42             | Passed |
| BVA-TC17 | IMAGE        | 1,000,000.00      | 8                  | 8,500,042.50              | 8,500,042.50             | Passed |
| BVA-TC18 | IMAGE        | 1,000,000.01      | 8                  | IllegalArgumentException  | IllegalArgumentException | Passed |
| BVA-TC19 | IMAGE        | 12.50             | 8                  | 148.75                    | 148.75                   | Passed |
| BVA-TC20 | IMAGE        | 12.50             | 0                  | IllegalArgumentException  | IllegalArgumentException | Passed |
| BVA-TC21 | IMAGE        | 12.50             | 1                  | 210.00                    | 210.00                   | Passed |
| BVA-TC22 | IMAGE        | 12.50             | 2                  | 210.00                    | 210.00                   | Passed |
| BVA-TC23 | IMAGE        | 12.50             | 1,000,000          | 148.75                    | 148.75                   | Passed |
| BVA-TC24 | IMAGE        | 12.50             | Integer.MAX_VALUE  | 148.75                    | 148.75                   | Passed |
| BVA-TC25 | VIDEO        | 0.00              | 8                  | IllegalArgumentException  | IllegalArgumentException | Passed |
| BVA-TC26 | VIDEO        | 0.01              | 8                  | 105.16                    | 105.16                   | Passed |
| BVA-TC27 | VIDEO        | 0.02              | 8                  | 105.32                    | 105.32                   | Passed |
| BVA-TC28 | VIDEO        | 999,999.99        | 8                  | 12,750,084.87             | 12,750,084.87            | Passed |
| BVA-TC29 | VIDEO        | 1,000,000.00      | 8                  | 12,750,085.00             | 12,750,085.00            | Passed |
| BVA-TC30 | VIDEO        | 1,000,000.01      | 8                  | IllegalArgumentException  | IllegalArgumentException | Passed |
| BVA-TC31 | VIDEO        | 12.50             | 8                  | 244.38                    | 244.38                   | Passed |
| BVA-TC32 | VIDEO        | 12.50             | 0                  | IllegalArgumentException  | IllegalArgumentException | Passed |
| BVA-TC33 | VIDEO        | 12.50             | 1                  | 345.00                    | 345.00                   | Passed |
| BVA-TC34 | VIDEO        | 12.50             | 2                  | 345.00                    | 345.00                   | Passed |
| BVA-TC35 | VIDEO        | 12.50             | 1,000,000          | 244.38                    | 244.38                   | Passed |
| BVA-TC36 | VIDEO        | 12.50             | Integer.MAX_VALUE  | 244.38                    | 244.38                   | Passed |
| BVA-TC37 | null         | 0.00              | 8                  | IllegalArgumentException  | IllegalArgumentException | Passed |
| BVA-TC38 | null         | 0.01              | 8                  | IllegalArgumentException  | IllegalArgumentException | Passed |
| BVA-TC39 | null         | 0.02              | 8                  | IllegalArgumentException  | IllegalArgumentException | Passed |
| BVA-TC40 | null         | 999,999.99        | 8                  | IllegalArgumentException  | IllegalArgumentException | Passed |
| BVA-TC41 | null         | 1,000,000.00      | 8                  | IllegalArgumentException  | IllegalArgumentException | Passed |
| BVA-TC42 | null         | 1,000,000.01      | 8                  | IllegalArgumentException  | IllegalArgumentException | Passed |
| BVA-TC43 | null         | 12.50             | 8                  | IllegalArgumentException  | IllegalArgumentException | Passed |
| BVA-TC44 | null         | 12.50             | 0                  | IllegalArgumentException  | IllegalArgumentException | Passed |
| BVA-TC45 | null         | 12.50             | 1                  | IllegalArgumentException  | IllegalArgumentException | Passed |
| BVA-TC46 | null         | 12.50             | 2                  | IllegalArgumentException  | IllegalArgumentException | Passed |
| BVA-TC47 | null         | 12.50             | 1,000,000          | IllegalArgumentException  | IllegalArgumentException | Passed |
| BVA-TC48 | null         | 12.50             | Integer.MAX_VALUE  | IllegalArgumentException  | IllegalArgumentException | Passed |