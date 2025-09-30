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

| Id   | analysisType | dataSize         | processingTime    | Expected Output           | Actual Output | Result |
|------|--------------|------------------|-------------------|---------------------------|---------------|--------|
| TC1  | TEXT         | 0.00             | 8                 | IllegalArgumentException  | IllegalArgumentException              | Passed |
| TC2  | TEXT         | 0.01             | 8                 | 17.04                     | 17.04         | Passed |
| TC3  | TEXT         | 0.02             | 8                 | 17.09                     | 17.09         | Passed |
| TC4  | TEXT         | 1,000,000.00     | 8                 | 4,250,117.00              | 4,250,117.00  | Passed |
| TC5  | TEXT         | Double.MAX_VALUE | 8                 | Infinity                  | 0.0           | Failed |
| TC6  | TEXT         | 12.50            | 8                 | 70.13                     | 70.13         | Passed |
| TC7  | TEXT         | 12.50            | 0                 | IllegalArgumentException  | IllegalArgumentException              | Passed |
| TC8  | TEXT         | 12.50            | 1                 | 99.00                     | 99.00         | Passed |
| TC9  | TEXT         | 12.50            | 2                 | 99.00                     | 99.00         | Passed |
| TC10 | TEXT         | 12.50            | 1,000,000         | 70.13                     | 70.13         | Passed |
| TC11 | TEXT         | 12.50            | Integer.MAX_VALUE | 70.13                     | 70.13         | Passed |
| TC12 | IMAGE        | 0.00             | 8                 | IllegalArgumentException  | IllegalArgumentException              | Passed |
| TC13 | IMAGE        | 0.01             | 8                 | 42.59                     | 42.59         | Passed |
| TC14 | IMAGE        | 0.02             | 8                 | 42.67                     | 42.67         | Passed |
| TC15 | IMAGE        | 1,000,000.00     | 8                 | 8,500,042.50              | 8,500,042.50  | Passed |
| TC16 | IMAGE        | Double.MAX_VALUE | 8                 | Infinity                  | 0.0           | Failed |
| TC17 | IMAGE        | 12.50            | 8                 | 148.75                    | 148.75        | Passed |
| TC18 | IMAGE        | 12.50            | 0                 | IllegalArgumentException  | IllegalArgumentException              | Passed |
| TC19 | IMAGE        | 12.50            | 1                 | 210.00                    | 210.00        | Passed |
| TC20 | IMAGE        | 12.50            | 2                 | 210.00                    | 210.00        | Passed |
| TC21 | IMAGE        | 12.50            | 1,000,000         | 148.75                    | 148.75        | Passed |
| TC22 | IMAGE        | 12.50            | Integer.MAX_VALUE | 148.75                    | 148.75        | Passed |
| TC23 | VIDEO        | 0.00             | 8                 | IllegalArgumentException  | IllegalArgumentException              | Passed |
| TC24 | VIDEO        | 0.01             | 8                 | 105.16                    | 105.16        | Passed |
| TC25 | VIDEO        | 0.02             | 8                 | 105.32                    | 105.32        | Passed |
| TC26 | VIDEO        | 1,000,000.00     | 8                 | 12,750,085.00             | 12,750,085.00 | Passed |
| TC27 | VIDEO        | Double.MAX_VALUE | 8                 | Infinity                  | 0.0           | Failed |
| TC28 | VIDEO        | 12.50            | 8                 | 244.38                    | 244.38        | Passed |
| TC29 | VIDEO        | 12.50            | 0                 | IllegalArgumentException  | IllegalArgumentException              | Passed |
| TC30 | VIDEO        | 12.50            | 1                 | 345.00                    | 345.00        | Passed |
| TC31 | VIDEO        | 12.50            | 2                 | 345.00                    | 345.00        | Passed |
| TC32 | VIDEO        | 12.50            | 1,000,000         | 244.38                    | 244.38        | Passed |
| TC33 | VIDEO        | 12.50            | Integer.MAX_VALUE | 244.38                    | 244.38        | Passed |
| TC34 | null         | 0.00             | 8                 | IllegalArgumentException  | IllegalArgumentException              | Passed |
| TC35 | null         | 0.01             | 8                 | IllegalArgumentException  |  IllegalArgumentException             | Passed |
| TC36 | null         | 0.02             | 8                 | IllegalArgumentException  | IllegalArgumentException              | Passed |
| TC37 | null         | 1,000,000.00     | 8                 | IllegalArgumentException  | IllegalArgumentException              | Passed |
| TC38 | null         | Double.MAX_VALUE | 8                 | IllegalArgumentException  | IllegalArgumentException              | Passed |
| TC39 | null         | 12.50            | 8                 | IllegalArgumentException  | IllegalArgumentException              | Passed |
| TC40 | null         | 12.50            | 0                 | IllegalArgumentException  | IllegalArgumentException              | Passed |
| TC41 | null         | 12.50            | 1                 | IllegalArgumentException  | IllegalArgumentException              | Passed |
| TC42 | null         | 12.50            | 2                 | IllegalArgumentException  | IllegalArgumentException              | Passed |