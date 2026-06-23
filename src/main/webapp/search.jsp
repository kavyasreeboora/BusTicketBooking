<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Search Bus</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">

<style>
body{
    background: linear-gradient(to right, #4facfe, #00f2fe);
    min-height: 100vh;
}

.search-card{
    margin-top: 80px;
    border-radius: 20px;
}
</style>

</head>
<body>

<div class="container">

    <div class="row justify-content-center">

        <div class="col-md-6">

            <div class="card shadow-lg search-card">

                <div class="card-header bg-info text-white text-center">
                    <h3>🚌 Search Bus</h3>
                </div>

                <div class="card-body p-4">

                    <form action="searchBus" method="get">

                        <div class="mb-3">
                            <label class="form-label">Source</label>
                            <input type="text"
                                   name="source"
                                   class="form-control"
                                   placeholder="Enter Source City"
                                   required>
                        </div>

                        <div class="mb-3">
                            <label class="form-label">Destination</label>
                            <input type="text"
                                   name="destination"
                                   class="form-control"
                                   placeholder="Enter Destination City"
                                   required>
                        </div>

                        <div class="d-grid">
                            <button type="submit"
                                    class="btn btn-info text-white">
                                Search Bus
                            </button>
                        </div>

                    </form>

                </div>

                <div class="card-footer text-center text-muted">
                    Find available buses and book your journey.
                </div>

            </div>

        </div>

    </div>

</div>

</body>
</html>